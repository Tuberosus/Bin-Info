package ru.me.bin_info.data.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.me.bin_info.data.database.AppDatabase
import ru.me.bin_info.data.database.entities.HistoryEntity
import ru.me.bin_info.data.dto.bin_info.BinInfoRequest
import ru.me.bin_info.data.dto.bin_info.BinInfoResponse
import ru.me.bin_info.data.network.NetworkClient
import ru.me.bin_info.domain.api.BinInfoRepository
import ru.me.bin_info.domain.models.Bin
import ru.me.bin_info.util.HttpStatusCode
import ru.me.bin_info.util.Resource

class BinInfoRepositoryImpl(
    private val networkClient: NetworkClient,
    private val db: AppDatabase
) : BinInfoRepository {

    override suspend fun getBinInfo(bin: String): Flow<Resource<Bin>> = flow {
        val response = networkClient.doRequest(BinInfoRequest(bin))
        emit(when (response.resultCode) {
            HttpStatusCode.OK -> {
                with(response as BinInfoResponse) {
                    val data = Bin(
                        country = country.name,
                        lon = country.longitude,
                        lat = country.latitude,
                        cardType = brand,
                        bank = bank
                    )
                    saveInHistory(bin, data)
                    Resource.Success(data)
                }
            }

            HttpStatusCode.NOT_CONNECTED -> Resource.Error("Проверьте подключение к сети")
            HttpStatusCode.BAD_REQUEST -> Resource.Error("Ошибка запроса")
            HttpStatusCode.NOT_FOUND -> Resource.Error("Не найдено")
            HttpStatusCode.HIT_LIMIT -> Resource.Error("Превышен лимит запросов")
            HttpStatusCode.INTERNAL_SERVER_ERROR -> Resource.Error("Ошибка сервера")
        })
    }

    private suspend fun saveInHistory(bin: String, data: Bin) {
        val entity = HistoryEntity(
            bin = bin,
            bankName = data.bank.name,
            country = data.country,
            addTime = System.currentTimeMillis()
        )
        db.historyDao().insertHistory(entity)
    }
}
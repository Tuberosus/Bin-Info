package ru.me.bin_info.domain.impl

import kotlinx.coroutines.flow.Flow
import ru.me.bin_info.domain.api.BinInfoRepository
import ru.me.bin_info.domain.api.GetBinInfoUseCase
import ru.me.bin_info.domain.models.Bin
import ru.me.bin_info.util.Resource

class GetBinInfoUseCaseImpl(
    private val repository: BinInfoRepository
) : GetBinInfoUseCase {
    override suspend fun execute(bin: String): Flow<Resource<Bin>> {
        return repository.getBinInfo(bin)
    }
}
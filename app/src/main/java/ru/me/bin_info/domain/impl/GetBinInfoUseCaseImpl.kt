package ru.me.bin_info.domain.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.me.bin_info.domain.api.BinInfoRepository
import ru.me.bin_info.domain.api.GetBinInfoUseCase
import ru.me.bin_info.domain.models.BinInfo
import ru.me.bin_info.util.Resource

class GetBinInfoUseCaseImpl(
    private val repository: BinInfoRepository
) : GetBinInfoUseCase {
    override suspend fun search(bin: String): Flow<BinInfo> {
        return repository.getBinInfo(bin).map { resource ->
            when (resource) {
                is Resource.Success -> BinInfo(bin = resource.data)
                is Resource.Error -> BinInfo(errorMessage = resource.message)
            }
        }
    }

}
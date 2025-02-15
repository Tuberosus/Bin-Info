package ru.me.bin_info.domain.api

import kotlinx.coroutines.flow.Flow
import ru.me.bin_info.domain.models.Bin
import ru.me.bin_info.util.Resource

interface GetBinInfoUseCase {
    suspend fun execute(bin: String): Flow<Resource<Bin>>
}
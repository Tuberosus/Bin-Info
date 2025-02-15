package ru.me.bin_info.domain.api

import kotlinx.coroutines.flow.Flow
import ru.me.bin_info.domain.models.BinInfo

interface GetBinInfoUseCase {
    suspend fun search(bin: String): Flow<BinInfo>
}
package ru.me.bin_info.di

import org.koin.dsl.module
import ru.me.bin_info.domain.api.GetBinInfoUseCase
import ru.me.bin_info.domain.api.GetHistoryUseCase
import ru.me.bin_info.domain.impl.GetBinInfoUseCaseImpl
import ru.me.bin_info.domain.impl.GetHistoryUseCaseImpl

val useCaseModule = module {
    factory<GetBinInfoUseCase> {
        GetBinInfoUseCaseImpl(get())
    }

    factory<GetHistoryUseCase> {
        GetHistoryUseCaseImpl(get())
    }
}
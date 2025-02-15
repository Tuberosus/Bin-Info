package ru.me.bin_info.di

import org.koin.dsl.module
import ru.me.bin_info.domain.api.GetBinInfoUseCase
import ru.me.bin_info.domain.impl.GetBinInfoUseCaseImpl

val useCaseModule = module {
    factory<GetBinInfoUseCase> {
        GetBinInfoUseCaseImpl(get())
    }
}
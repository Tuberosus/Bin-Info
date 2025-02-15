package ru.me.bin_info.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.me.bin_info.presentation.SearchViewModel

val viewModelModel = module {
    viewModel<SearchViewModel> {
        SearchViewModel(get())
    }
}
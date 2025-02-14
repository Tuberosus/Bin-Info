package ru.me.bin_info.presentation

import ru.me.bin_info.domain.models.Bin

sealed class SearchScreenState {
    data object Empty : SearchScreenState()
    data class Error(val message: String) : SearchScreenState()
    data object Loading : SearchScreenState()
    data class Content(val bin: Bin) : SearchScreenState()
}
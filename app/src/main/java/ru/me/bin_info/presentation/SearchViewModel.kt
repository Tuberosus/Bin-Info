package ru.me.bin_info.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    private var _state = MutableLiveData<SearchScreenState>()
    val state: LiveData<SearchScreenState> get() = _state

    init {
        _state.value = SearchScreenState.Empty
    }
}
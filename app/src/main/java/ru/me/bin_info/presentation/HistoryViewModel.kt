package ru.me.bin_info.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.me.bin_info.domain.api.GetHistoryUseCase
import ru.me.bin_info.domain.models.HistoryItem

class HistoryViewModel(
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {

    private val _state = MutableLiveData<List<HistoryItem>>()
    val state: LiveData<List<HistoryItem>> = _state

    init {
        getHistory()
    }

    private fun getHistory() {
        viewModelScope.launch {
            getHistoryUseCase.get()
                .collect{ historyList ->
                    _state.postValue(historyList)
                }
        }
    }
}
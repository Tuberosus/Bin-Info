package ru.me.bin_info.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.me.bin_info.domain.api.GetBinInfoUseCase
import ru.me.bin_info.domain.models.BinInfo

class SearchViewModel(
    private val getBinInfoUseCase: GetBinInfoUseCase
) : ViewModel() {

    private var _state = MutableLiveData<SearchScreenState>()
    val state: LiveData<SearchScreenState> get() = _state

    init {
        _state.value = SearchScreenState.Empty
    }

    fun getBinInfo(bin: String) {
        if (bin.isNotEmpty()) {
            _state.value = SearchScreenState.Loading

            viewModelScope.launch {
                getBinInfoUseCase.search(bin)
                    .collect{ binInfo ->
                        processResult(binInfo)
                    }
            }
        }
    }

    private fun processResult(binInfo: BinInfo) {
        when {
            binInfo.errorMessage != null-> {
                _state.postValue(SearchScreenState.Error(binInfo.errorMessage))
            }
            binInfo.bin != null -> {
                _state.postValue(SearchScreenState.Content(binInfo.bin))
            }
        }
    }
}
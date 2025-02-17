package ru.me.bin_info.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.me.bin_info.domain.api.ExternalInteractor
import ru.me.bin_info.domain.api.GetBinInfoUseCase
import ru.me.bin_info.domain.models.Bin
import ru.me.bin_info.domain.models.BinInfo

class SearchViewModel(
    private val getBinInfoUseCase: GetBinInfoUseCase,
    private val externalInteractor: ExternalInteractor
) : ViewModel() {

    private var _state = MutableLiveData<SearchScreenState>()
    val state: LiveData<SearchScreenState> get() = _state

    private var binResult: Bin? = null

    init {
        _state.value = SearchScreenState.Empty
    }

    fun getBinInfo(bin: String) {
        if (bin.isNotEmpty()) {
            _state.value = SearchScreenState.Loading

            viewModelScope.launch(Dispatchers.IO) {
                getBinInfoUseCase.search(bin)
                    .collect{ binInfo ->
                        processResult(binInfo)
                    }
            }
        }
    }

    fun processActionIntent(intent: NavigationIntent) {
        when (intent) {
            is NavigationIntent.Dial -> binResult?.bank?.phone?.let {
                externalInteractor.openDial(it)
            }
            is NavigationIntent.Map -> binResult?.let {
                externalInteractor.openMap(it.lat.toFloat(), it.lon.toFloat())
            }
            is NavigationIntent.Url -> binResult?.bank?.url?.let {
                externalInteractor.openUrl(it)
            }
        }
    }

    fun setEmptyState() {
        _state.value = SearchScreenState.Empty
    }

    private fun processResult(binInfo: BinInfo) {
        when {
            binInfo.errorMessage != null-> {
                _state.postValue(SearchScreenState.Error(binInfo.errorMessage))
            }
            binInfo.bin != null -> {
                binResult = binInfo.bin
                _state.postValue(SearchScreenState.Content(binInfo.bin))
            }
        }
    }
}
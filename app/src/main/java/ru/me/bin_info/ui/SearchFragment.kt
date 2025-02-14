package ru.me.bin_info.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.me.bin_info.databinding.FragmentSearchBinding
import ru.me.bin_info.domain.models.Bin
import ru.me.bin_info.presentation.SearchScreenState
import ru.me.bin_info.presentation.SearchViewModel

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModel()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner) { state ->
            render(state)
        }
    }

    private fun render(state: SearchScreenState) {
        when (state) {
            is SearchScreenState.Content -> showContent(state)
            SearchScreenState.Empty -> showEmpty()
            is SearchScreenState.Error -> showError(state)
            SearchScreenState.Loading -> showLoading()
        }
    }

    private fun showContent(state: SearchScreenState.Content) {
        searchResultVisibility(true)
        errorMessageVisibility(false)
        progressBarVisibility(false)
        setSearchResult(state.bin)
    }

    private fun showEmpty() {
        searchResultVisibility(false)
        errorMessageVisibility(false)
        progressBarVisibility(false)
    }

    private fun showError(state: SearchScreenState.Error) {
        searchResultVisibility(false)
        errorMessageVisibility(true)
        progressBarVisibility(false)

        binding.errorMessage.text = state.message
    }

    private fun showLoading() {
        searchResultVisibility(false)
        errorMessageVisibility(false)
        progressBarVisibility(true)
    }

    private fun searchResultVisibility(setVisible: Boolean) {
        binding.apply {
            searchResult.root.isVisible = setVisible
            closeIcon.isVisible = setVisible
        }
    }

    private fun progressBarVisibility(setVisible: Boolean) {
        binding.progressBar.isVisible = setVisible
    }

    private fun errorMessageVisibility(setVisible: Boolean) {
        binding.errorMessage.isVisible = setVisible
    }

    private fun setSearchResult(bin: Bin) {
        binding.searchResult.apply {
            countryValue.text = bin.country
            coordinationValue.text = "${bin.lat}  ${bin.lon}"
            cardTypeValue.text = bin.cardType
            bankUrlValue.text = bin.bank.url
            bankPhoneValue.text = bin.bank.phone
            bankCityValue.text = bin.bank.city
        }
    }
}
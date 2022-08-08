package uk.mhl.swapx.ui.currency_selection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.data.repository.ExchangeRepository
import javax.inject.Inject

@HiltViewModel
class CurrencySelectionViewModel @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : ViewModel() {

    // region State



    // endregion

    // region Initialisation

    init {

    }

    // endregion

    // region Selection

    fun onCurrencySelected(currency: Currency) {
        viewModelScope.launch {
            exchangeRepository.updateFromCurrencyToStore(currency.name)
        }
    }

    // endregion

}
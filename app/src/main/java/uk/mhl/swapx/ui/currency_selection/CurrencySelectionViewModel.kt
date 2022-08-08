package uk.mhl.swapx.ui.currency_selection

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import uk.mhl.swapx.data.model.Conversion
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.data.model.fromAsCurrency
import uk.mhl.swapx.data.model.toAsCurrency
import uk.mhl.swapx.data.repository.ExchangeRepository
import uk.mhl.swapx.ui.model.ConversionDirection
import uk.mhl.swapx.ui.model.ConversionDirection.From
import uk.mhl.swapx.ui.model.ConversionDirection.To
import uk.mhl.swapx.ui.navigation.Destinations.CurrencySelection.Key
import javax.inject.Inject

@HiltViewModel
class CurrencySelectionViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val exchangeRepository: ExchangeRepository
) : ViewModel() {

    // region Conversion direction argument

    private val conversionDirection: ConversionDirection = savedStateHandle[Key.Direction]!!

    // endregion

    // region View state

    val state = exchangeRepository
        .observeStoredConversion()
        .mapToViewState()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = CurrencySelectionViewState()
        )

    // endregion

    // region Helpers

    private fun Flow<Conversion>.mapToViewState(): Flow<CurrencySelectionViewState> {
        return map {
            CurrencySelectionViewState(
                when (conversionDirection) {
                    From -> it.fromAsCurrency()
                    To -> it.toAsCurrency()
                }
            )
        }
    }

    // endregion

    // region Selection

    fun onCurrencySelected(currency: Currency) {
        viewModelScope.launch {
            when (conversionDirection) {
                From -> exchangeRepository.updateFromCurrency(currency.name)
                To -> exchangeRepository.updateToCurrency(currency.name)
            }
        }
    }

    // endregion

}
package uk.mhl.swapx.ui.exchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.data.repository.ExchangeRepository
import uk.mhl.swapx.ui.view.Key
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : ViewModel() {

    // region

    private val _fromCurrency = MutableStateFlow(Currency.CAD)
    private val _toCurrency = MutableStateFlow(Currency.NOK)
    private val _fromAmount = MutableStateFlow("0")
    private val _toAmount = MutableStateFlow("0")

    val state = combine(
        _fromCurrency,
        _toCurrency,
        _fromAmount,
        _toAmount
    ) { fromCurrency, toCurrency, fromValue, toValue ->
        ExchangeViewState(fromCurrency, toCurrency, fromValue, toValue)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ExchangeViewState()
    )

    // region Initialisation

    init {

    }

    // endregion

    // region Amount updates

    fun onNumberPadKeyClicked(key: Key) {
        var amount = _fromAmount.value

        when (key) {
            Key.Backspace -> {
                amount = if (amount.length > 1) {
                    amount.dropLast(1)
                } else {
                    "0"
                }
            }
            Key.Decimal -> {
                if (!amount.contains(".") && amount.isNotEmpty()) {
                    amount += "."
                }
            }
            else -> {
                if (amount.length == 1 && amount == "0") {
                    amount = key.display
                } else {
                    amount += key.display
                }
            }
        }

        _fromAmount.tryEmit(amount)
        runConversion()
    }

    // endregion

    // region Conversion

    private fun runConversion() {
        viewModelScope.launch {
            val fromAsDouble = _fromAmount.value.toDoubleOrNull() ?: 0.00
            val rates = exchangeRepository.getExchangeForBase(_fromCurrency.value.name)[0].rates
            val rate = rates[_toCurrency.value.name] ?: 0.00

            val amountDouble = fromAsDouble * rate
            _toAmount.tryEmit(String.format("%.2f", amountDouble) )
        }
    }

    // endregion

}
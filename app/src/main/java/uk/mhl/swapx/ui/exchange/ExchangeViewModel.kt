package uk.mhl.swapx.ui.exchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import uk.mhl.swapx.data.repository.ExchangeRepository
import uk.mhl.swapx.ui.view.Key
import java.text.DecimalFormat
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : ViewModel() {

    // region View state
    private val fromAmount = MutableStateFlow("0")
    private val toAmount = MutableStateFlow("0")

    val state = combine(
        exchangeRepository.observeStoredConversion(),
        fromAmount,
        toAmount
    ) { conversion, fromValue, toValue ->
        ExchangeViewState(conversion, fromValue, toValue)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ExchangeViewState()
    )

    // endregion

    // region Amount updates

    fun onNumberPadKeyClicked(key: Key) {
        var amount = fromAmount.value

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

        fromAmount.tryEmit(amount)
        runConversion()
    }

    // endregion

    // region Conversion

    fun runConversion() {
        viewModelScope.launch {
            val fromAsDouble = fromAmount.value.toDoubleOrNull() ?: 0.00
            val fromCurrencyCode = state.value.conversion.fromCurrencyCode.ifEmpty { "EUR" }
            val toCurrencyCode = state.value.conversion.toCurrencyCode.ifEmpty { "USD" }

            val exchange = exchangeRepository.getExchangeForBase(fromCurrencyCode)
            val rates = if (exchange.isNotEmpty()) {
                exchange[0].rates
            } else {
                emptyMap()
            }

            val rate = rates[toCurrencyCode] ?: 0.00

            val amountDouble = fromAsDouble * rate

            val formatter = DecimalFormat("#,###,##0.##")
            toAmount.tryEmit(formatter.format(amountDouble))
        }
    }

    // endregion

}
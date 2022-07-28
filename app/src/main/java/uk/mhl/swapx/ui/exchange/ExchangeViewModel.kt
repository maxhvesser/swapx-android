package uk.mhl.swapx.ui.exchange

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.ui.view.Key
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(

) : ViewModel() {

    // region

    private val _fromCurrency = MutableStateFlow(Currency.EUR)
    private val _toCurrency = MutableStateFlow(Currency.USD)
    private val _fromAmount = MutableStateFlow(0.00)
    private val _toAmount = MutableStateFlow(0.00)

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

    }

    // endregion

}
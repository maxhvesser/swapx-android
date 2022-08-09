package uk.mhl.swapx.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.data.repository.ExchangeRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : ViewModel() {

    // region View state

    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    // endregion

    // region Initialization

    init {
        downloadExchangeRates()
    }

    // endregion

    // region Download rates

    private fun downloadExchangeRates() {
        viewModelScope.launch {
            val currencies = Currency.values()

            val exchangeRatesTask = currencies.map { currency ->
                async {
                    exchangeRepository.getLatestForBase(currency.name)
                }
            }

            val exchangeRatesResult = exchangeRatesTask.awaitAll()
            exchangeRepository.storeExchangeRates(exchangeRatesResult)

            _loading.tryEmit(false)
        }
    }

    // endregion

}
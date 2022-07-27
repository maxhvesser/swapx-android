package uk.mhl.swapx.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.data.repository.ExchangeRepository
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : ViewModel() {

    // region State properties

    private val _loading = MutableStateFlow(true)

    val state = _loading
        .map { loading ->
            SplashViewState(loading)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = SplashViewState()
        )

    // endregion

    // region Initialisation

    init {
        getExchangeRates()
    }

    // endregion

    // region Get currencies

    private fun getExchangeRates() {
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
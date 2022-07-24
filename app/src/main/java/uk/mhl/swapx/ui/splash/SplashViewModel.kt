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

    private val _loading = MutableStateFlow<Boolean>(true)

    val state = _loading
        .map {
            SplashViewState(it)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = true
        )

    // endregion

    // region Initialisation

    init {
        // Download currencies
    }

    // endregion

    // region Get currencies

    private fun downloadExchangeLatest() {
        viewModelScope.launch {
            val currencies = Currency.values()

            val tasks = currencies.map { currency ->
                async {
                    exchangeRepository.getLatestForBase(currency.name)
                }
            }

            val responses = tasks.awaitAll()

            // Update database with values
            val t = responses
        }
    }

    // endregion

}

// viewModelScope.launch {
//    withContext(dispatcherProvider.heavyTasks) {
//        val multipleIds = listOf(1, 2, 3, 4, 5, ..)
//        val content = arrayListOf<CustomObj>()
//
//        val runningTasks = multipleIds.map { id ->
//                async { // this will allow us to run multiple tasks in parallel
//                    val apiResponse = api.get(id)
//                    id to apiResponse // associate id and response for later
//                }
//        }
//
//        val responses = runningTasks.awaitAll()
//
//        responses.forEach { (id, response) ->
//            if (response.isSuccessful()) {
//                content.find { it.id == id }.enable = true
//            }
//        }
//
//        liveData.postValue(content)
//    }
//}
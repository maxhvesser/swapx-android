package uk.mhl.swapx.ui.navigation

import androidx.compose.material3.MaterialTheme
import com.google.accompanist.insets.ui.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.mhl.swapx.ui.currency_selection.CurrencySelection
import uk.mhl.swapx.ui.exchange.Exchange
import uk.mhl.swapx.ui.rememberSwapAppState
import uk.mhl.swapx.ui.splash.Splash

@Composable
fun NavGraph() {
    val state = rememberSwapAppState()

    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background
    ) { padding ->
        val contentPadding = padding

        NavHost(
            navController = state.navController,
            startDestination = Destinations.Splash.Route
        ) {
            composable(Destinations.Splash.Route) { backStack ->
                Splash(
                    viewModel = hiltViewModel(backStack),
                    openExchange = state.navigator.openExchange
                )
            }

            composable(Destinations.Exchange.Route) {
                Exchange(
                    openCurrencySelection = state.navigator.openCurrencySelection
                )
            }

            composable(Destinations.CurrencySelection.Route) {
                CurrencySelection()
            }
        }
    }
}
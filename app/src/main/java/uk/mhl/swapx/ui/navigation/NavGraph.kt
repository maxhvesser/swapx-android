package uk.mhl.swapx.ui.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.mhl.swapx.ui.exchange.Exchange
import uk.mhl.swapx.ui.rememberSwapAppState

@Composable
fun NavGraph() {
    val appState = rememberSwapAppState()

    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        val contentPadding = it

        NavHost(
            navController = appState.navController,
            startDestination = Destinations.Exchange.Route
        ) {
            composable(Destinations.Exchange.Route) {
                Exchange()
            }
        }
    }
}
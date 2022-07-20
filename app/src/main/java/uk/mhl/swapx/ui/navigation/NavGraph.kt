package uk.mhl.swapx.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.mhl.swapx.ui.rememberSwapAppState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph() {
    val appState = rememberSwapAppState()

    Scaffold(
    ) {
        val contentPadding = it

        NavHost(
            navController = appState.navController,
            startDestination = Destinations.Exchange.Route
        ) {
            composable(Destinations.Exchange.Route) {

            }
        }
    }
}
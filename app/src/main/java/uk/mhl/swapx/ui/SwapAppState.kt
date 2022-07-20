package uk.mhl.swapx.ui

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun rememberSwapAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) = remember(scaffoldState) {
    SwapAppState(scaffoldState, navController, resources, coroutineScope)
}

@Stable
class SwapAppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    val resources: Resources,
    val coroutineScope: CoroutineScope
) {
    init {
        coroutineScope.launch {
            // Setup snackbar here when ready to
        }
    }
}

@Composable
@ReadOnlyComposable
private fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}
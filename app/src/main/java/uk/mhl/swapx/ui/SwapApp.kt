package uk.mhl.swapx.ui

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import uk.mhl.swapx.ui.navigation.NavGraph
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.util.LocalBackDispatcher

@Composable
fun SwapApp(
    backDispatcher: OnBackPressedDispatcher
) {
    CompositionLocalProvider(LocalBackDispatcher provides backDispatcher) {
        SwapTheme {
            NavGraph()
        }
    }
}
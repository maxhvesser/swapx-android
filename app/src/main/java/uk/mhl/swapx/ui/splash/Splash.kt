package uk.mhl.swapx.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import uk.mhl.swapx.ui.theme.SwapTheme

// region Entry

@Composable
fun Splash(
    viewModel: SplashViewModel,
    openExchange: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.loading) {
        if (!state.loading) {
            openExchange()
        }
    }

    Content()
}

// endregion

// region Content

@Composable
private fun Content() {

}

// endregion

// region Preview

@Preview(showBackground = true)
@Composable
fun Preview_Content() {
    SwapTheme {

    }
}

// endregion
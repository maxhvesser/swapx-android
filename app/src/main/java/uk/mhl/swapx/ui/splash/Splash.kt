package uk.mhl.swapx.ui.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.mhl.swapx.ui.theme.SwapTheme

// region Entry

@Composable
fun Splash(
    model: SplashViewModel,
    openExchange: () -> Unit
) {
    val state by model.state.collectAsState()

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
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary
        )
    }
}

// endregion

// region Preview

@Preview(showBackground = true)
@Composable
fun Preview_Content() {
    SwapTheme {
        Content()
    }
}

// endregion
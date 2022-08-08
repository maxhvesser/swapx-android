package uk.mhl.swapx.ui.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.R
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
    LoadingIcon()
}

// endregion

// region Loading

@Composable
private fun LoadingIcon() {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        )
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box {
            Icon(
                modifier = Modifier.
                size(130.dp)
                .graphicsLayer {
                    rotationZ = angle
                },
                painter = painterResource(R.drawable.ic_currency_arrows),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Icon(
                modifier = Modifier.size(130.dp),
                painter = painterResource(R.drawable.ic_currency_dollar),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
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
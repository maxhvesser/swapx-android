package uk.mhl.swapx.ui.exchange

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.R
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.data.model.fromAsCurrency
import uk.mhl.swapx.data.model.toAsCurrency
import uk.mhl.swapx.ui.model.ConversionDirection
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.view.CurrencyCard
import uk.mhl.swapx.ui.view.Key
import uk.mhl.swapx.ui.view.NumberPad

// region Entry
@Composable
fun Exchange(
    model: ExchangeViewModel,
    openCurrencySelection: (ConversionDirection) -> Unit
) {
    val state by model.state.collectAsState()

    LaunchedEffect(state.conversion) {
        model.runConversion()
    }

    Content(
        fromCurrency = state.conversion.fromAsCurrency(),
        toCurrency = state.conversion.toAsCurrency(),
        fromAmount = state.fromAmount,
        toAmount = state.toAmount,
        openCurrencySelection = openCurrencySelection,
        onNumberPadKeyClicked = model::onNumberPadKeyClicked
    )
}

// endregion

// region Content

@Composable
private fun Content(
    fromCurrency: Currency,
    toCurrency: Currency,
    fromAmount: String,
    toAmount: String,
    openCurrencySelection: (ConversionDirection) -> Unit,
    onNumberPadKeyClicked: (Key) -> Unit
) {
    var sizeToOffset by remember { mutableStateOf(0f) }
    var swapped by remember { mutableStateOf(false) }
    val offset by animateFloatAsState(if (swapped) sizeToOffset else 0f)

    val density = LocalDensity.current

    Column {
        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier
                .onGloballyPositioned {
                    with (density) {
                        sizeToOffset = it.size.height + 56.dp.toPx()
                    }
                }
                .graphicsLayer(
                    translationY = offset
                )
        ) {
            CurrencyCard(
                amount = fromAmount,
                currency = fromCurrency.fullName,
                currencyCode = fromCurrency.name,
                onCardClicked = { openCurrencySelection(ConversionDirection.From) }
            )
        }
        SwapButton(
            onClick = {
                swapped = !swapped
            }
        )
        Box(
            modifier = Modifier
                .graphicsLayer(
                    translationY = -offset
                )
        ) {
            CurrencyCard(
                amount = toAmount,
                currency = toCurrency.fullName,
                currencyCode = toCurrency.name,
                onCardClicked = { openCurrencySelection(ConversionDirection.To) }
            )
        }
        Spacer(Modifier.weight(1f))
        NumberPad(
            onKeyClicked = onNumberPadKeyClicked
        )
    }
}

@Composable
private fun SwapButton(
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Divider(
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
        )
        ExtendedFloatingActionButton(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            text = {
                Text(
                    text = stringResource(R.string.exchange_button_swap)
                )
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_swap),
                    contentDescription = null
                )
            },
            onClick = onClick
        )
    }
}

// endregion

// region Preview

@Preview(showBackground = true)
@Composable
fun Preview_Content() {
    SwapTheme {
        Content(
            fromCurrency = Currency.EUR,
            toCurrency = Currency.USD,
            fromAmount = "0.00",
            toAmount = "0.00",
            openCurrencySelection = { },
            onNumberPadKeyClicked = { }
        )
    }
}

// endregion
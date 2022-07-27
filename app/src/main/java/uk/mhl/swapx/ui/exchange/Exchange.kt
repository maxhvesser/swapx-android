package uk.mhl.swapx.ui.exchange

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import uk.mhl.swapx.R
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.view.CurrencyCard
import uk.mhl.swapx.ui.view.NumberPad

// region Entry
@Composable
fun Exchange(
    model: ExchangeViewModel,
    openCurrencySelection: () -> Unit
) {
    val state by model.state.collectAsState()

    Content(
        fromCurrency = state.fromCurrency,
        toCurrency = state.toCurrency,
        fromAmount = state.fromAmount,
        toAmount = state.toAmount,
        openCurrencySelection = openCurrencySelection
    )
}

// endregion

// region Content

@Composable
private fun Content(
    fromCurrency: Currency,
    toCurrency: Currency,
    fromAmount: Double,
    toAmount: Double,
    openCurrencySelection: () -> Unit
) {
    Column {
        Spacer(Modifier.weight(1f))
        CurrencyCard(
            amount = String.format("%.2f", fromAmount),
            currency = fromCurrency.fullName,
            currencyCode = fromCurrency.name,
            onCardClicked = openCurrencySelection
        )
        SwapButton()
        CurrencyCard(
            amount = String.format("%.2f", toAmount),
            currency = toCurrency.fullName,
            currencyCode = toCurrency.name,
            onCardClicked = openCurrencySelection
        )
        Spacer(Modifier.weight(1f))
        NumberPad(
            onKeyClicked = { }
        )
    }
}

@Composable
private fun SwapButton() {
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
                    text = "Swap"
                )
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.ic_swap),
                    contentDescription = null
                )
            },
            onClick = { }
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
            fromAmount = 0.00,
            toAmount = 0.00,
            openCurrencySelection = { }
        )
    }
}

// endregion
package uk.mhl.swapx.ui.exchange

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.view.CurrencyCard
import uk.mhl.swapx.ui.view.NumberPad
import uk.mhl.swapx.R

// region Entry
@Composable
fun Exchange() {
    Content()
}

// endregion

// region Content

@Composable
private fun Content() {
    Column {
        Spacer(Modifier.weight(1f))
        CurrencyCard(
            amount = "0.00",
            currency = "Canadian Dollars",
            currencyCode = "CAD",
            onCardClicked = { }
        )
        SwapButton()
        CurrencyCard(
            amount = "0.00",
            currency = "Norwegian Kroners",
            currencyCode = "NOK",
            onCardClicked = { }
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
        Content()
    }
}

// endregion
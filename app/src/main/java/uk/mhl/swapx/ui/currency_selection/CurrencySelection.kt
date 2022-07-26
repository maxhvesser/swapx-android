package uk.mhl.swapx.ui.currency_selection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.view.BackArrowNavigation
import uk.mhl.swapx.ui.view.CurrencyRow
import uk.mhl.swapx.ui.view.SwapAppBar

// region Entry

@Composable
fun CurrencySelection(
    navigateUp: () -> Unit
) {
    Content(
        navigateUp = navigateUp
    )
}

// endregion

// region Content

@Composable
private fun Content(
    navigateUp: () -> Unit
) {
    Column {
        SwapAppBar(
            title = "Currency",
            navigationIcon = {
                BackArrowNavigation(navigateUp)
            }
        )
        CurrencyList()
    }
}

@Composable
private fun CurrencyList() {
    val currencies = Currency.values()

    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ) {
        items(currencies) { currency ->
            CurrencyRow(
                currency = currency,
                selected = currency == Currency.CAD,
                onRowClicked = { }
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
        Content(
            navigateUp = { }
        )
    }
}

// endregion
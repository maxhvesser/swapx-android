package uk.mhl.swapx.ui.currency_selection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.R
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.view.BackArrowNavigation
import uk.mhl.swapx.ui.view.CurrencyRow
import uk.mhl.swapx.ui.view.SwapAppBar

// region Entry

@Composable
fun CurrencySelection(
    model: CurrencySelectionViewModel,
    navigateUp: () -> Unit
) {
    Content(
        navigateUp = navigateUp,
        onCurrencySelected = model::onCurrencySelected
    )
}

// endregion

// region Content

@Composable
private fun Content(
    navigateUp: () -> Unit,
    onCurrencySelected: (Currency) -> Unit
) {
    Column {
        SwapAppBar(
            title = stringResource(R.string.currency_selection_title),
            navigationIcon = {
                BackArrowNavigation(navigateUp)
            }
        )
        CurrencyList(
            navigateUp = navigateUp,
            onCurrencySelected = onCurrencySelected
        )
    }
}

@Composable
private fun CurrencyList(
    navigateUp: () -> Unit,
    onCurrencySelected: (Currency) -> Unit
) {
    val currencies = Currency.values()

    LazyColumn(
        contentPadding = PaddingValues(12.dp)
    ) {
        items(currencies) { currency ->
            CurrencyRow(
                currency = currency,
                selected = currency == Currency.CAD,
                onRowClicked = {
                    onCurrencySelected(currency)
                    navigateUp()
                }
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
            navigateUp = { },
            onCurrencySelected = { }
        )
    }
}

// endregion
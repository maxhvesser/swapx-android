package uk.mhl.swapx.ui.currency_selection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.mhl.swapx.R
import uk.mhl.swapx.data.model.Currency
import uk.mhl.swapx.ui.theme.SwapTheme
import uk.mhl.swapx.ui.util.shouldLift
import uk.mhl.swapx.ui.view.BackArrowNavigation
import uk.mhl.swapx.ui.view.CurrencyRow
import uk.mhl.swapx.ui.view.SwapAppBar

// region Entry

@Composable
fun CurrencySelection(
    model: CurrencySelectionViewModel,
    navigateUp: () -> Unit
) {
    val state by model.state.collectAsState()
    val currencyListState = rememberLazyListState()

    Content(
        selectedCurrency = state.selectedCurrency,
        currencyListState = currencyListState,
        navigateUp = navigateUp,
        onCurrencySelected = model::onCurrencySelected
    )
}

// endregion

// region Content

@Composable
private fun Content(
    selectedCurrency: Currency,
    currencyListState: LazyListState,
    navigateUp: () -> Unit,
    onCurrencySelected: (Currency) -> Unit
) {
    Column {
        SwapAppBar(
            title = stringResource(R.string.currency_selection_title),
            navigationIcon = {
                BackArrowNavigation(navigateUp)
            },
            shouldLift = currencyListState.shouldLift
        )
        CurrencyList(
            selectedCurrency = selectedCurrency,
            currencyListState = currencyListState,
            navigateUp = navigateUp,
            onCurrencySelected = onCurrencySelected
        )
    }
}

@Composable
private fun CurrencyList(
    selectedCurrency: Currency,
    currencyListState: LazyListState,
    navigateUp: () -> Unit,
    onCurrencySelected: (Currency) -> Unit
) {
    val currencies = Currency.values()

    LazyColumn(
        state = currencyListState,
        contentPadding = PaddingValues(12.dp)
    ) {
        items(currencies) { currency ->
            CurrencyRow(
                currency = currency,
                selected = currency == selectedCurrency,
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
            selectedCurrency = Currency.CAD,
            currencyListState = rememberLazyListState(),
            navigateUp = { },
            onCurrencySelected = { }
        )
    }
}

// endregion
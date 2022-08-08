package uk.mhl.swapx.ui.currency_selection

import uk.mhl.swapx.data.model.Currency

data class CurrencySelectionViewState(
    val selectedCurrency: Currency = Currency.EUR
)
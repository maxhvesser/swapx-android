package uk.mhl.swapx.ui.exchange

import uk.mhl.swapx.data.model.Currency

data class ExchangeViewState(
    val fromCurrency: Currency = Currency.EUR,
    val toCurrency: Currency = Currency.USD,
    val fromAmount: String = "0",
    val toAmount: String = "0"
)
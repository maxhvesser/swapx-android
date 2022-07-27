package uk.mhl.swapx.ui.exchange

import uk.mhl.swapx.data.model.Currency

data class ExchangeViewState(
    val fromCurrency: Currency = Currency.EUR,
    val toCurrency: Currency = Currency.USD,
    val fromAmount: Double = 0.00,
    val toAmount: Double = 0.00
)
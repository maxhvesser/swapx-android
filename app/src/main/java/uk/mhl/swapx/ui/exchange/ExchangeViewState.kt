package uk.mhl.swapx.ui.exchange

import uk.mhl.swapx.data.model.Conversion

data class ExchangeViewState(
    val conversion: Conversion = Conversion(),
    val fromAmount: String = "0",
    val toAmount: String = "0"
)
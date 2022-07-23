package uk.mhl.swapx.data.model

data class ExchangeLatest(
    val base: String,
    val date: String,
    val rates: List<Rate>
)
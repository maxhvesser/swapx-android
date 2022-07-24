package uk.mhl.swapx.data.database.model

data class ExchangeEntity(
    val base: String,
    val date: String,
    val rates: List<RateEntity>
)
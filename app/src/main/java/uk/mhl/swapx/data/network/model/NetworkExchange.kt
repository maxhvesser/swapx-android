package uk.mhl.swapx.data.network.model

data class NetworkExchange(
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)
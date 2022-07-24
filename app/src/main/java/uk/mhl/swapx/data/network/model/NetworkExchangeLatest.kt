package uk.mhl.swapx.data.network.model

data class NetworkExchangeLatest(
    val base: String,
    val date: String,
    val rates: List<NetworkRate>
)
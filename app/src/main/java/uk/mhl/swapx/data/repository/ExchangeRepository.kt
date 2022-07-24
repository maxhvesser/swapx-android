package uk.mhl.swapx.data.repository

import uk.mhl.swapx.data.network.ExchangeService
import uk.mhl.swapx.data.network.model.NetworkExchange
import javax.inject.Inject

class ExchangeRepository @Inject constructor(
    private val exchangeService: ExchangeService
) {

    // region Latest

    suspend fun getLatestForBase(baseCurrency: String): NetworkExchange {
        val response = exchangeService.getLatestForBase(baseCurrency)

        return if (response.isSuccessful) {
            response.body() ?: NetworkExchange("", "", emptyList())
        } else {
            NetworkExchange("", "", emptyList())
        }
    }

    // endregion

}
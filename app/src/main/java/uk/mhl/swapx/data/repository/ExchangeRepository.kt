package uk.mhl.swapx.data.repository

import uk.mhl.swapx.data.network.ExchangeApi
import uk.mhl.swapx.data.network.ExchangeService
import uk.mhl.swapx.data.network.model.NetworkExchange
import uk.mhl.swapx.data.network.model.NetworkRates
import javax.inject.Inject

class ExchangeRepository @Inject constructor(
    private val exchangeService: ExchangeService
) {

    // region Latest

    suspend fun getLatestForBase(baseCurrency: String): NetworkExchange {
        val response = exchangeService.getLatestForBase(
            source = ExchangeApi.Param.Source.Default,
            base= baseCurrency
        )

        return if (response.isSuccessful) {
            response.body() ?: NetworkExchange("", "", NetworkRates())
        } else {
            NetworkExchange("", "", NetworkRates())
        }
    }

    // endregion

}
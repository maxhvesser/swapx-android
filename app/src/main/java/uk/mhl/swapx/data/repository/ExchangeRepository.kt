package uk.mhl.swapx.data.repository

import uk.mhl.swapx.data.database.dao.ExchangeDao
import uk.mhl.swapx.data.database.model.ExchangeEntity
import uk.mhl.swapx.data.model.toEntity
import uk.mhl.swapx.data.network.ExchangeApi
import uk.mhl.swapx.data.network.ExchangeService
import javax.inject.Inject

class ExchangeRepository @Inject constructor(
    private val exchangeService: ExchangeService,
    private val exchangeDao: ExchangeDao
) {

    // region Network

    suspend fun getLatestForBase(baseCurrency: String): ExchangeEntity {
        val response = exchangeService.getLatestForBase(
            source = ExchangeApi.Param.Source.Default,
            base= baseCurrency
        )

        return response.body()?.toEntity() ?: ExchangeEntity(0,"", "", emptyMap())
    }

    // endregion

    // region Database

    suspend fun storeExchangeRates(rates: List<ExchangeEntity>) {
        exchangeDao.insertAll(rates)
    }

    // endregion

}
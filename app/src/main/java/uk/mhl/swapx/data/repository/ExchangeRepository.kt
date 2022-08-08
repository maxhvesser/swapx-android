package uk.mhl.swapx.data.repository

import kotlinx.coroutines.flow.Flow
import uk.mhl.swapx.data.database.dao.ExchangeDao
import uk.mhl.swapx.data.database.model.ExchangeEntity
import uk.mhl.swapx.data.datastore.ConversionManager
import uk.mhl.swapx.data.model.Conversion
import uk.mhl.swapx.data.model.toEntity
import uk.mhl.swapx.data.network.ExchangeApi
import uk.mhl.swapx.data.network.ExchangeService
import javax.inject.Inject

class ExchangeRepository @Inject constructor(
    private val exchangeService: ExchangeService,
    private val exchangeDao: ExchangeDao,
    private val conversionManager: ConversionManager
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
        exchangeDao.clearTable()
        exchangeDao.insertAll(rates)
    }

    suspend fun getAvailableCurrencyCodes(): List<String> {
        return exchangeDao.getAvailableCurrencyCodes()
    }

    suspend fun getExchangeForBase(currencyCode: String): List<ExchangeEntity> {
        return exchangeDao.getRatesForBase(currencyCode)
    }

    // endregion

    // region Datastore

    fun observeStoredConversion(): Flow<Conversion> {
        return conversionManager.getConversion
    }

    suspend fun updateFromCurrency(fromCurrencyCode: String) {
        conversionManager.updateFromCurrencyCode(fromCurrencyCode)
    }

    suspend fun updateToCurrency(toCurrencyCode: String) {
        conversionManager.updateToCurrencyCode(toCurrencyCode)
    }

    // endregion

}
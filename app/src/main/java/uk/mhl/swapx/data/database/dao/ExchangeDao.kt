package uk.mhl.swapx.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uk.mhl.swapx.data.database.model.ExchangeEntity
import uk.mhl.swapx.data.model.Currency

@Dao
interface ExchangeDao {

    // region Create

    @Insert
    suspend fun insertAll(exchangeRates: List<ExchangeEntity>)

    // endregion

    // region Read

    @Query("SELECT * FROM exchangeEntity")
    suspend fun getAll(): List<ExchangeEntity>

    @Query("SELECT * FROM exchangeEntity WHERE base = :currencyCode LIMIT 1")
    suspend fun getRatesForBase(currencyCode: String): List<ExchangeEntity>

    @Query("SELECT base FROM exchangeEntity")
    suspend fun getAvailableCurrencyCodes(): List<String>

    // endregion

    // region Delete

    @Query("DELETE FROM exchangeEntity")
    suspend fun clearTable()

    // endregion

}
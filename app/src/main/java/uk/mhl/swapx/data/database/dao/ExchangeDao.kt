package uk.mhl.swapx.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uk.mhl.swapx.data.database.model.ExchangeEntity

@Dao
interface ExchangeDao {

    // region Create

    @Insert
    suspend fun insertAll(exchangeRates: List<ExchangeEntity>)

    // endregion

    // region Read

    @Query("SELECT * FROM exchangeEntity")
    suspend fun getAll(): List<ExchangeEntity>

    // endregion

    // region Delete

    @Query("DELETE FROM exchangeEntity")
    suspend fun clearTable()

    // endregion

}
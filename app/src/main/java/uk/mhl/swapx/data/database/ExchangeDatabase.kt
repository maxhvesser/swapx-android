package uk.mhl.swapx.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uk.mhl.swapx.data.database.dao.ExchangeDao
import uk.mhl.swapx.data.database.model.ExchangeEntity

@Database(entities = [ExchangeEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class ExchangeDatabase : RoomDatabase() {
    abstract fun exchangeDao(): ExchangeDao
}
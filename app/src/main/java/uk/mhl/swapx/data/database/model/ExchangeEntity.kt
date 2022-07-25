package uk.mhl.swapx.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExchangeEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    @ColumnInfo(name = "base")
    val base: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "rates")
    val rates: Map<String, Double>
)
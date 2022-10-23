package uk.mhl.swapx.data.database

import androidx.room.TypeConverter
import java.util.TreeMap

class Converters {

    // region Map<String, Double>

    @TypeConverter
    fun fromString(value: Map<String, Double>): String {
        val sortedMap = TreeMap(value)

        return sortedMap.keys.joinToString(separator = ",").plus("<divider>")
            .plus(sortedMap.values.joinToString(separator = ","))
    }

    @TypeConverter
    fun toString(value: String): Map<String, Double> {
        return value.split("<divider>").run {
            val keys = getOrNull(0)?.split(",")?.map { it }
            val values = getOrNull(1)?.split(",")?.map { it }

            val result = hashMapOf<String, Double>()
            keys?.forEachIndexed { index, key ->
                result[key] = (values?.getOrNull(index) ?: "0").toDouble()
            }

            result
        }
    }

    // endregion

}
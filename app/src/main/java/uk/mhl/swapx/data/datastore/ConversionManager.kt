package uk.mhl.swapx.data.datastore

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.mhl.swapx.data.model.Conversion
import javax.inject.Inject

class ConversionManager @Inject constructor(
    private val context: Context
) {

    // region Read

    val getConversion: Flow<Conversion> = context.conversionDataStore.data.map {
        Conversion(
            fromCurrencyCode = it.fromCurrencyCode,
            toCurrencyCode = it.toCurrencyCode
        )
    }

    // endregion

    // region Update

    suspend fun updateConversion(conversion: Conversion) {
        context.conversionDataStore.updateData { current ->
            current.toBuilder()
                .setFromCurrencyCode(conversion.fromCurrencyCode)
                .setToCurrencyCode(conversion.toCurrencyCode)
                .build()
        }
    }

    suspend fun updateFromCurrencyCode(code: String) {
        context.conversionDataStore.updateData { current ->
            current.toBuilder()
                .setFromCurrencyCode(code)
                .build()
        }
    }

    suspend fun updateToCurrencyCode(code: String) {
        context.conversionDataStore.updateData { current ->
            current.toBuilder()
                .setToCurrencyCode(code)
                .build()
        }
    }

    // endregion

}
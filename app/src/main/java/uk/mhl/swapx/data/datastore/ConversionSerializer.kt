package uk.mhl.swapx.data.datastore

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import uk.swapx.Conversion
import java.io.InputStream
import java.io.OutputStream

object ConversionSerializer : Serializer<Conversion> {

    override val defaultValue: Conversion
        get() = Conversion.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Conversion {
        try {
            return Conversion.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto", exception)
        } catch (exception: Exception) {
            throw exception
        }
    }

    override suspend fun writeTo(t: Conversion, output: OutputStream) {
        return t.writeTo(output)
    }

}

val Context.conversionDataStore: DataStore<Conversion> by dataStore(
    fileName = "conversion.pb",
    serializer = ConversionSerializer
)
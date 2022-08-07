package uk.mhl.swapx.data.model

// region Model

data class Conversion(
    val fromCurrencyCode: String,
    val toCurrencyCode: String
)

// endregion

// region Helpers

fun Conversion.fromCurrencyAsDouble(): Double {
    return fromCurrencyCode.toDoubleOrNull() ?: 0.0
}

fun Conversion.toCurrencyAsDouble(): Double {
    return toCurrencyCode.toDoubleOrNull() ?: 0.0
}

// endregion
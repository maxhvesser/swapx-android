package uk.mhl.swapx.data.model

// region Model

data class Conversion(
    val fromCurrencyCode: String = "EUR",
    val toCurrencyCode: String = "USD"
)

// endregion

// region Helpers

fun Conversion.fromAsDouble(): Double {
    return fromCurrencyCode.toDoubleOrNull() ?: 0.0
}

fun Conversion.toAsDouble(): Double {
    return toCurrencyCode.toDoubleOrNull() ?: 0.0
}

fun Conversion.fromAsCurrency(): Currency {
    return Currency.values().firstOrNull { it.name == fromCurrencyCode } ?: Currency.EUR
}

fun Conversion.toAsCurrency(): Currency {
    return Currency.values().firstOrNull { it.name == toCurrencyCode } ?: Currency.USD
}

// endregion
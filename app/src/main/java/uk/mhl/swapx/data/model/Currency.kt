package uk.mhl.swapx.data.model

/**
 * Representation of a currency
 * @property name The name of the currency.
 * @property code The ISO 4217 currency code.
 * @property iconAsset The drawable asset for this currency
 */
data class Currency(
    val name: String = "",
    val code: String = "",
    val iconAsset: Int = 0
)
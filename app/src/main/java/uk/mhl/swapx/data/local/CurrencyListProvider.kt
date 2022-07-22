package uk.mhl.swapx.data.local

import uk.mhl.swapx.R
import uk.mhl.swapx.data.model.Currency

class CurrencyListProvider {

    // region List of currencies

    fun currencies(): List<Currency> {
        return listOf(
            Currency("Australian Dollar", "AUD", R.drawable.ic_aud),
            Currency("Brazilian Real", "BRL", R.drawable.ic_brl),
            Currency("Bulgarian Lev", "BGN", R.drawable.ic_bgn),
            Currency("Canadian Dollar", "CAD", R.drawable.ic_cad),
            Currency("Chinese Yuan", "CNY", R.drawable.ic_cny),
            Currency("Croatian Kuna", "HRK", R.drawable.ic_hrk),
            Currency("Czech Koruna", "CZK", R.drawable.ic_czk),
            Currency("Danish Krone", "DKK", R.drawable.ic_dkk),
            Currency("Euro", "EUR", R.drawable.ic_eur),
            Currency("Great British Pound", "GBP", R.drawable.ic_gbp),
            Currency("Hong Kong Dollar", "HKD", R.drawable.ic_hkd),
            Currency("Hungarian Forint", "HUF", R.drawable.ic_huf),
            Currency("Icelandic Krone", "ISK", R.drawable.ic_isk),
            Currency("Indonesian Rupiajh", "IDR", R.drawable.ic_idr),
            Currency("Israeli New Shekel", "ILS", R.drawable.ic_ils),
            Currency("Indian Rupee", "INR", R.drawable.ic_inr),
            Currency("Japanese Yen", "JPY", R.drawable.ic_jpy),
            Currency("Malaysian Ringgit", "MYR", R.drawable.ic_myr),
            Currency("Mexican Peso", "MXN", R.drawable.ic_mxn),
            Currency("New Zealand Dollar", "NZD", R.drawable.ic_nzd),
            Currency("Norwegian Krone", "NOK", R.drawable.ic_nok),
            Currency("Philippine Peso", "PHP", R.drawable.ic_php),
            Currency("Polish Zloty", "PLN", R.drawable.ic_pln),
            Currency("Romanian Leu", "RON", R.drawable.ic_ron),
            Currency("Russian Ruble", "RUB", R.drawable.ic_rub),
            Currency("South African Rand", "ZAR", R.drawable.ic_zar),
            Currency("South Korean Won", "KRW", R.drawable.ic_krw),
            Currency("Singapore Dollar", "SGD", R.drawable.ic_sgd),
            Currency("Swedish Krone", "SEK", R.drawable.ic_sek),
            Currency("Swiss Franc", "CHF", R.drawable.ic_chf),
            Currency("Thai Baht", "THB", R.drawable.ic_thb),
            Currency("Turkish Lira", "TRY", R.drawable.ic_try),
            Currency("United States Dollar", "USD", R.drawable.ic_usd)
        )
    }

    // endregion

}
package uk.mhl.swapx.data.model

import uk.mhl.swapx.R

enum class Currency(
    val fullName: String,
    val asset: Int
) {
    AUD("Australian Dollar", R.drawable.ic_aud),
    BRL("Brazilian Real", R.drawable.ic_brl),
    BGN("Bulgarian Lev", R.drawable.ic_bgn),
    CAD("Canadian Dollar", R.drawable.ic_cad),
    CNY("Chinese Yuan", R.drawable.ic_cny),
    HRK("Croatian Kuna", R.drawable.ic_hrk),
    CZK("Czech Koruna", R.drawable.ic_czk),
    DKK("Danish Krone", R.drawable.ic_dkk),
    EUR("Euro", R.drawable.ic_eur),
    GBP("Great British Pound", R.drawable.ic_gbp),
    HKD("Hong Kong Dollar", R.drawable.ic_hkd),
    HUF("Hungarian Forint", R.drawable.ic_huf),
    ISK("Icelandic Krone", R.drawable.ic_isk),
    IDR("Indonesian Rupiajh", R.drawable.ic_idr),
    ILS("Israeli New Shekel", R.drawable.ic_ils),
    INR("Indian Rupee", R.drawable.ic_inr),
    JPY("Japanese Yen", R.drawable.ic_jpy),
    MYR("Malaysian Ringgit", R.drawable.ic_myr),
    MXN("Mexican Peso", R.drawable.ic_mxn),
    NZD("New Zealand Dollar", R.drawable.ic_nzd),
    NOK("Norwegian Krone", R.drawable.ic_nok),
    PHP("Philippine Peso", R.drawable.ic_php),
    PLN("Polish Zloty", R.drawable.ic_pln),
    RON("Romanian Leu", R.drawable.ic_ron),
    RUB("Russian Ruble", R.drawable.ic_rub),
    ZAR("South African Rand", R.drawable.ic_zar),
    KRW("South Korean Won", R.drawable.ic_krw),
    SGD("Singapore Dollar", R.drawable.ic_sgd),
    SEK("Swedish Krone", R.drawable.ic_sek),
    CHF("Swiss Franc", R.drawable.ic_chf),
    THB("Thai Baht", R.drawable.ic_thb),
    TRY("Turkish Lira", R.drawable.ic_try),
    USD("United States Dollar", R.drawable.ic_usd)
}
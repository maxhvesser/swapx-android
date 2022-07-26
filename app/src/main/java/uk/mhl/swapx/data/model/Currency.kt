package uk.mhl.swapx.data.model

import uk.mhl.swapx.R

enum class Currency(
    val fullName: String,
    val asset: Int
) {
    AUD("Australian Dollar", R.drawable.ic_aud),
    BGN("Bulgarian Lev", R.drawable.ic_bgn),
    BRL("Brazilian Real", R.drawable.ic_brl),
    CAD("Canadian Dollar", R.drawable.ic_cad),
    CHF("Swiss Franc", R.drawable.ic_chf),
    CNY("Chinese Yuan", R.drawable.ic_cny),
    CZK("Czech Koruna", R.drawable.ic_czk),
    DKK("Danish Krone", R.drawable.ic_dkk),
    EUR("Euro", R.drawable.ic_eur),
    GBP("Great British Pound", R.drawable.ic_gbp),
    HKD("Hong Kong Dollar", R.drawable.ic_hkd),
    HRK("Croatian Kuna", R.drawable.ic_hrk),
    HUF("Hungarian Forint", R.drawable.ic_huf),
    IDR("Indonesian Rupiajh", R.drawable.ic_idr),
    ILS("Israeli New Shekel", R.drawable.ic_ils),
    INR("Indian Rupee", R.drawable.ic_inr),
    ISK("Icelandic Krone", R.drawable.ic_isk),
    JPY("Japanese Yen", R.drawable.ic_jpy),
    KRW("South Korean Won", R.drawable.ic_krw),
    MXN("Mexican Peso", R.drawable.ic_mxn),
    MYR("Malaysian Ringgit", R.drawable.ic_myr),
    NOK("Norwegian Krone", R.drawable.ic_nok),
    NZD("New Zealand Dollar", R.drawable.ic_nzd),
    PHP("Philippine Peso", R.drawable.ic_php),
    PLN("Polish Zloty", R.drawable.ic_pln),
    RON("Romanian Leu", R.drawable.ic_ron),
    // 26/07/2022: RUB not currently available from API.
    // RUB("Russian Ruble", R.drawable.ic_rub),
    SEK("Swedish Krone", R.drawable.ic_sek),
    SGD("Singapore Dollar", R.drawable.ic_sgd),
    THB("Thai Baht", R.drawable.ic_thb),
    TRY("Turkish Lira", R.drawable.ic_try),
    USD("United States Dollar", R.drawable.ic_usd),
    ZAR("South African Rand", R.drawable.ic_zar)
}
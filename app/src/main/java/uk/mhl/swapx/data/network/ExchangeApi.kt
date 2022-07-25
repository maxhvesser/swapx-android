package uk.mhl.swapx.data.network

object ExchangeApi {
    const val BaseUrl: String = "https://api.exchangerate.host"
    const val Latest: String = "latest"

    object Param {
        object Base {
            const val Key: String = "base"
        }

        object Source {
            const val Key: String = "source"
            const val Default: String = "ecb"
        }
    }
}
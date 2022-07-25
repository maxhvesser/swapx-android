package uk.mhl.swapx.data.model

import uk.mhl.swapx.data.database.model.ExchangeEntity
import uk.mhl.swapx.data.network.model.NetworkExchange

fun NetworkExchange.toEntity(): ExchangeEntity {
    return ExchangeEntity(
        uid = 0,
        base = base,
        date = date,
        rates = rates
    )
}
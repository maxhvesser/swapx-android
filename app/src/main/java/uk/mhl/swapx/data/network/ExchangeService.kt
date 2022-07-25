package uk.mhl.swapx.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uk.mhl.swapx.data.network.model.NetworkExchange

interface ExchangeService {

    // region Latest

    @GET(ExchangeApi.Latest)
    suspend fun getLatestForBase(
        @Query(ExchangeApi.Param.Source.Key) source: String,
        @Query(ExchangeApi.Param.Base.Key) base: String
    ) : Response<NetworkExchange>

    // endregion

}
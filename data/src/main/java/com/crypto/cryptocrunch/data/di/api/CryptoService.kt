package com.crypto.cryptocrunch.di.api

import com.crypto.cryptocrunch.data.model.DefiRepoRes
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import io.reactivex.Flowable

const val BASE_API_URL = "/api/v1"

interface CryptoService {

    @Headers("Content-Type: application/json")
    @GET("${BASE_API_URL}/defi/svc/{id}")
    fun getDefiDetail(
        @Path("id") id : String
    ) : Flowable<DefiRepoRes>
}
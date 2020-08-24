package com.fedyshyn.kotlinflow.api

import com.fedyshyn.kotlinflow.repository.data.ApiLocationDetails
import kotlinx.coroutines.InternalCoroutinesApi
import retrofit2.http.GET
import retrofit2.http.Path

@InternalCoroutinesApi
interface FlowApiService {

    @GET("location/{woeid}/")
    suspend fun getLocationDetails(@Path("woeid") woeid: Int): ApiLocationDetails
}
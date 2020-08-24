package com.fedyshyn.kotlinflow.repository

import com.fedyshyn.kotlinflow.repository.data.ApiLocationDetails
import com.fedyshyn.kotlinflow.api.FlowApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.metaweather.com/api/"

@InternalCoroutinesApi
class MainRepository {

    private var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var service: FlowApiService = retrofit.create(FlowApiService::class.java)

    suspend fun getLocationDetails(locationId: Int): Flow<ApiLocationDetails> {
        return flow {
            val fooList = service.getLocationDetails(locationId)

            emit(fooList)
        }.flowOn(Dispatchers.IO)
    }

    companion object {

        @Volatile
        private var instance: MainRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) { instance ?: MainRepository().also { instance = it } }
    }
}
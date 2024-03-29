package com.example.animalcare.service.retrofit

import androidx.lifecycle.LiveData
import com.example.animalcare.Repository
import com.example.animalcare.database.entities.ley_entity
import com.example.animalcare.database.entities.org_entity
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val GITHUB_API_BASE_URI = "https://animal-care.herokuapp.com/"

interface ApiService {

    @GET("/ley")
    fun getleyes():  Deferred<Response<LiveData<ley_entity>>>

    @GET("/organizacion")
    fun getorgs():  Deferred<Response<LiveData<org_entity>>>

    @GET("/ley/{ley_name}")
    fun getleye(@Path("ley_name")ley_name:String): Deferred<Response<LiveData<List<ley_entity>>>>

    @GET("/organizacion/{org_name}")
    fun getorg(@Path("org_name")org_name:String): Deferred<Response<LiveData<List<org_entity>>>>



    companion object{
        fun getRetrofit():ApiService = Retrofit.Builder()
            .baseUrl(GITHUB_API_BASE_URI)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    }

}
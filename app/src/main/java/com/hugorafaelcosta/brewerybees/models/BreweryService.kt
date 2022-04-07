package com.hugorafaelcosta.brewerybees.models

import com.hugorafaelcosta.brewerybees.database.models.BreweryModel
import retrofit2.Call
import retrofit2.http.GET

interface BreweryService {
    @GET("topTen")
    fun getBrewery(): Call<BreweryModel>

//    companion object {
//        private val retrofitService: BreweryService by lazy {
//
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://bootcamp-mobile-01.eastus.cloudapp.azure.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            retrofit.create(BreweryService::class.java)
//        }
//
//        fun getInstance(): BreweryService {
//            return retrofitService
//        }
//    }
}

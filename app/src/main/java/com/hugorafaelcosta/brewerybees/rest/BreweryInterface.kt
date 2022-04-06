package com.hugorafaelcosta.brewerybees.rest

import com.hugorafaelcosta.brewerybees.database.models.BreweryModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BreweryInterface {
    @GET("/breweries/topTen")
    fun getBrewery(): Call<BreweryModel>

    companion object {
        private val retrofitService: BreweryInterface by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://bootcamp-mobile-01.eastus.cloudapp.azure.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(BreweryInterface::class.java)
        }

        fun getInstance(): BreweryInterface {
            return retrofitService
        }
    }
}

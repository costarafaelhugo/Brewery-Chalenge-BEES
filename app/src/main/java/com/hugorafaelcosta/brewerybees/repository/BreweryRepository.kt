package com.hugorafaelcosta.brewerybees.repository

import com.hugorafaelcosta.brewerybees.database.models.BreweryModel
import com.hugorafaelcosta.brewerybees.models.BreweryService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BreweryRepository {
    //https://bootcamp-mobile-01.eastus.cloudapp.azure.com/breweries

    private val service: BreweryService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://bootcamp-mobile-01.eastus.cloudapp.azure.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(BreweryService::class.java)
    }

    fun getBrewery(): BreweryModel? {
        val call = service.getBrewery()

        return call.execute().body()
    }
}


//    fun getBrewery(callBack:(BreweryModel?)-> Unit) {
//        BreweryInterface.getInstance().getBrewery().enqueue(object : retrofit2.Callback<BreweryModel>{
//            override fun onResponse(call: Call<BreweryModel>, response: Response<BreweryModel>) {
//               callBack.invoke(response.body())
//            }
//
//            override fun onFailure(call: Call<BreweryModel>, t: Throwable) {
//                callBack.invoke(null)
//            }
//
//        })
//    }

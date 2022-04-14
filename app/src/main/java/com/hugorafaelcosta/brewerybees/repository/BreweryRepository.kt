package com.hugorafaelcosta.brewerybees.repository

import com.hugorafaelcosta.brewerybees.rest.BreweryInterface

class BreweryRepository {
    //https://bootcamp-mobile-01.eastus.cloudapp.azure.com/breweries
    suspend fun getBrewery() = BreweryInterface.getInstance().getBrewery()
}
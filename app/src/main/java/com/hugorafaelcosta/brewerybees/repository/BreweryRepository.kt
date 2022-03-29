package com.hugorafaelcosta.brewerybees.repository

import com.hugorafaelcosta.brewerybees.database.daos.BreweryInterface

class BreweryRepository {
    //https://bootcamp-mobile-01.eastus.cloudapp.azure.com/breweries
    fun getBrewery() = BreweryInterface.getInstance().getBrewery()
}
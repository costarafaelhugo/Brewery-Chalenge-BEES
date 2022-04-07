package com.hugorafaelcosta.brewerybees.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hugorafaelcosta.brewerybees.database.models.BreweryModel
import com.hugorafaelcosta.brewerybees.domain.Brewery
import com.hugorafaelcosta.brewerybees.repository.BreweryRepository

class BreweryMainViewModel : ViewModel() {
    var brewery = MutableLiveData<List<BreweryModel?>>()

    init {
        Thread(Runnable {
            loadBrewery()
        }).start()
    }

    private fun loadBrewery() {
        val breweryApiResult = BreweryRepository.getBrewery()

//        breweryApiResult?.results?.let {
//            brewery.postValue(it.map { pokemonResult ->
//                val number = pokemonResult.url
//                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
//                    .replace("/", "").toInt()

//        breweryApiResult = BreweryRepository.getBrewery()

        breweryApiResult?.let {
            Brewery(
                breweryApiResult.name,
                breweryApiResult.sizeEvaluations.toString(),
                breweryApiResult.breweryType
            )
        }
    }
}
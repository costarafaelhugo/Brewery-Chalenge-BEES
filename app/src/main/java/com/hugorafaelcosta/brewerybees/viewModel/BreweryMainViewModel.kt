package com.hugorafaelcosta.brewerybees.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugorafaelcosta.brewerybees.database.models.BreweryModel
import com.hugorafaelcosta.brewerybees.repository.BreweryRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BreweryMainViewModel(val repository: BreweryRepository) : ViewModel() {

    private val _brewery = MutableLiveData<List<BreweryModel>?>()
    val brewery: LiveData<List<BreweryModel>?> = _brewery



    fun getBreweryList() {

        val result = repository.getBrewery()

        result.enqueue(object : Callback<List<BreweryModel>> {
            override fun onResponse(
                call: Call<List<BreweryModel>>,
                response: Response<List<BreweryModel>>
            ) {
                if (response.code() == 200) {
                    val breweryData = response.body()
                    _brewery.postValue(breweryData)
                }
            }

            override fun onFailure(call: Call<List<BreweryModel>>, t: Throwable) {
                Log.e("Error",    "Erro ao buscar os dados - $t.message ")

            }

        })

//        viewModelScope.launch {
//            val response = repository.getBrewery()
//
//            if (response.isSuccessful) {
//                Log.d("DEUCERTO", response.toString())
//            } else {
//                Log.e("E", response.message())
//            }
//        }
    }
}
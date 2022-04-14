package com.hugorafaelcosta.brewerybees.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugorafaelcosta.brewerybees.repository.BreweryRepository
import kotlinx.coroutines.launch

class BreweryMainViewModel (val repository: BreweryRepository): ViewModel(){

    fun getBreweryList(){

        viewModelScope.launch {
            val response = repository.getBrewery()

            if (response.isSuccessful){
                Log.d("DEUCERTO", response.toString())
            }else{
                Log.e("E", response.message())
            }
        }
    }
}
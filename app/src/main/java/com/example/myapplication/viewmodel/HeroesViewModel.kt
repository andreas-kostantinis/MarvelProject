package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.MarvelHeroResponses
import com.example.myapplication.model.Characters
import com.example.myapplication.repository.Repository
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class HeroesViewModel(
    val repository : Repository
) : ViewModel() {


    var heroes: MutableLiveData<Resource<Characters>> = MutableLiveData()
    var heroespage = 1

    fun getHeroes(offset: Int, limit: Int, apikey: String, ts: String, hash: String) =
        viewModelScope.launch {
            val response = repository.getHeroes(offset, limit, apikey, ts, hash)

        }

    private fun handleHeroesResponse(response: Response<Characters>): Resource<Characters> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)

            }
        }
        return Resource.Error(response.message())

    }
}



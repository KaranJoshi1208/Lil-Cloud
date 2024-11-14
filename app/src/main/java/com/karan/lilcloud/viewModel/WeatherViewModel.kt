package com.karan.lilcloud.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karan.lilcloud.model.ApiService
import com.karan.lilcloud.model.RetrofitClient
import com.karan.lilcloud.model.Weather
import com.karan.lilcloud.repository.WeatherRepository
import kotlinx.coroutines.launch
import retrofit2.Call

class WeatherViewModel() : ViewModel() {

    private val repo: WeatherRepository = WeatherRepository(RetrofitClient.retrofit.create(ApiService::class.java))
    private val response : MutableLiveData<Call<Weather>> = MutableLiveData()

    fun loadCurrentWeather(lat:Double, lon:Double, unit:String) {
        viewModelScope.launch() {
            response.value = repo.getCurrentWeather(lat, lon, unit)
        }
    }
}
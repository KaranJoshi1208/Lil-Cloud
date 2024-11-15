package com.karan.lilcloud.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karan.lilcloud.model.ApiService
import com.karan.lilcloud.model.RetrofitClient
import com.karan.lilcloud.model.Weather
import com.karan.lilcloud.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel() : ViewModel() {

    private val repo: WeatherRepository = WeatherRepository(RetrofitClient.retrofit.create(ApiService::class.java))
    var weatherData = mutableStateOf<Weather?>(null)

    fun loadCurrentWeather(lat:Double, lon:Double, unit:String) {
        viewModelScope.launch() {

            try {
                val response = repo.getCurrentWeather(lat, lon, unit)
                weatherData.value = response
                Log.d("HowsTheWeather", "Weather: $response")
            }
            catch (e : Exception) {
                Log.e("HowsTheWeather", "Error fetching weather", e)
            }



//            (object : retrofit2.Callback<Weather> {
//                override fun onResponse(
//                    call: Call<Weather?>,
//                    response: Response<Weather?>
//                ) {
//                    if(response.isSuccessful) {
//                        response.body()?.also {
//                            weatherData.value = it
//                            Log.d("HowsTheWeather", it.toString())
//                        }
//                        Log.d("HowsTheWeather", "Its executing")
//                    }
//                }
//
//                override fun onFailure(
//                    call: Call<Weather?>,
//                    t: Throwable
//                ) {
//                    Log.d("HowsTheWeather" , "Not GOOD , Failed to get response !")
//                }
//            })
        }
    }
}
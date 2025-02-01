package com.karan.lilcloud.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherData(data : WeatherData)

    @Update
    suspend fun updateWeatherData(data: WeatherData)

    // to get List of all locations
    @Query("SELECT locationKey FROM weather_data")
    suspend fun getAllLocations() : List<String>

    // to get weather data by key
    @Query("SELECT * FROM weather_data WHERE locationKey = :key")
    suspend fun getWeatherData(key : String) : WeatherData

    // to get a list of containing all weather data entries
    @Query("SELECT * FROM weather_data")
    fun getAllWeatherData() : Flow<List<WeatherData>>

    // to delete a specific weather data entry
    @Query("DELETE FROM weather_data WHERE locationKey = :key")
    suspend fun deleteWeatherData(key : String)
}
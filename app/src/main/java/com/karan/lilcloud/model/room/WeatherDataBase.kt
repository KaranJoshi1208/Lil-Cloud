package com.karan.lilcloud.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [WeatherDataBase::class], version = 1, exportSchema = false)
abstract class WeatherDataBase : RoomDatabase(){

    abstract fun weatherDao() : WeatherDAO

    companion object {
        @Volatile
        private var INSTANCE : WeatherDataBase? = null

        fun getWeatherDataBase(context : Context) : WeatherDataBase {
            return INSTANCE ?: synchronized(lock = this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDataBase::class.java,
                    "weather_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
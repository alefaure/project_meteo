package com.meteo.iut.meteo

import android.app.Application
import com.meteo.iut.meteo.database.CityDbHelper
import com.meteo.iut.meteo.utils.WeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by adrien on 10/01/2018.
 */

private const val API_KEY = "0b7943ce0b8fca43"

class App : Application() {

    companion object {
        lateinit var instance: App

        val database: CityDbHelper by lazy {
            CityDbHelper(instance)
        }

        private val retrofit = Retrofit.Builder()
                .baseUrl("http://api.wunderground.com/api/$API_KEY/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val WEATHER_SERVICE: WeatherService = retrofit.create(WeatherService::class.java)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}
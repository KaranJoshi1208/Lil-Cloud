package com.karan.lilcloud.model.accuWeather

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiTemplate {

    /**
     * suspend GET function to get information about the region.
     * @param geoPosition Geographical Position, the text should be a comma-separated lat/lon pair i.e "lat,lon".
     * @param apiKey  API Key for Authentication
     */
    @GET("/locations/v1/cities/geoposition/search")
    suspend fun getLocationInfo(
        @Query("q") geoPosition : String,
        @Query("apikey") apiKey : String,
    ) : GeoPositionResponse


    @GET("/locations/v1/{locationKey}")
    suspend fun getLocationKeyInfo(
        @Path("locationKey") locationKey : String,
        @Query("apikey") apiKey : String,
    ) : GeoPositionResponse


    /**
     * suspend GET function to fetch the current Weather condition in provided Location.
     * @param locationKey Unique Location ID, retrieved using `getLocationInfo()`
     * @param apiKey  API Key for Authentication
     */
    @GET("/currentconditions/v1/{locationKey}")
    suspend fun getCurrentCondition(
        @Path("locationKey") locationKey : String,
        @Query("apikey") apiKey : String,
        @Query("details") details : String = "true"
    ) : CurrentConditionResponse

    @GET("/forecasts/v1/daily/1day/{locationKey}")
    suspend fun getDailyForecast(
        @Path("locationKey") locationKey: String,
        @Query("apikey") apiKey : String,
        @Query("details") details: String = "true",
        @Query("metric") metric : String = "true"
    ) : DailyForecastResponse


    @GET("/forecasts/v1/hourly/12hour/{locationKey}")
    suspend fun getHalfDayForecast(
        @Path("locationKey") locationKey: String,
        @Query("apikey") apiKey : String,
        @Query("metric") metric : String = "true"
    ) : HalfDayForecastResponse

    @GET("/forecasts/v1/daily/5day/{locationKey}")
    suspend fun getQuinForecast (
        @Path("locationKey") locationKey: String,
        @Query("apikey") apiKey : String,
        @Query("metric") metric : String = "true"
    ) : QuinForecastResponse

    @GET("/locations/v1/cities/autocomplete")
    suspend fun getSearch(
        @Query("q") q : String,
        @Query("apikey") apiKey : String,
    ) : SearchResponse
}
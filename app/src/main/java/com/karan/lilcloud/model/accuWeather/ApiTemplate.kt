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
        @Query("apikey") apiKey : String
    ) : GeoPositionResponse


    /**
     * suspend GET function to fetch the current Weather condition in provided Location.
     * @param locationKey Unique Location ID, retrieved using `getLocationInfo()`
     * @param apiKey  API Key for Authentication
     */
    @GET("/currentconditions/v1/{locationKey}")
    suspend fun getCurrentCondition(
        @Path("locationKey") locationKey : String,
        @Query("apikey") apiKey : String
    ) : CurrentConditionResponse
}
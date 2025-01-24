package com.karan.lilcloud.model.accuWeather


import com.google.gson.annotations.SerializedName
import com.karan.lilcloud.model.accuWeather.HalfDayForecastResponse.HalfDayForecastResponseItem

class HalfDayForecastResponse : ArrayList<HalfDayForecastResponseItem>(){
    data class HalfDayForecastResponseItem(
        @SerializedName("DateTime")
        val dateTime: String?,
//        @SerializedName("EpochDateTime")
//        val epochDateTime: Int?,
//        @SerializedName("HasPrecipitation")
//        val hasPrecipitation: Boolean?,
//        @SerializedName("IconPhrase")
//        val iconPhrase: String?,
//        @SerializedName("IsDaylight")
//        val isDaylight: Boolean?,
//        @SerializedName("Link")
//        val link: String?,
//        @SerializedName("MobileLink")
//        val mobileLink: String?,
//        @SerializedName("PrecipitationIntensity")
//        val precipitationIntensity: String?,
//        @SerializedName("PrecipitationProbability")
//        val precipitationProbability: Int?,
//        @SerializedName("PrecipitationType")
//        val precipitationType: String?,
        @SerializedName("Temperature")
        val temperature: Temperature?,
        @SerializedName("WeatherIcon")
        val weatherIcon: Int?
    ) : Comparable<HalfDayForecastResponseItem> {

        override fun compareTo(other: HalfDayForecastResponseItem): Int {
            val thisTemp = this.temperature?.value ?: Double.MIN_VALUE
            val otherTemp = other.temperature?.value ?: Double.MIN_VALUE
            return thisTemp.compareTo(otherTemp)
        }
        data class Temperature(
//            @SerializedName("Unit")
//            val unit: String?,
//            @SerializedName("UnitType")
//            val unitType: Int?,
            @SerializedName("Value")
            val value: Double?
        )
    }
}
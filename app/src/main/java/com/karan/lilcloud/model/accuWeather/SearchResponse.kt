package com.karan.lilcloud.model.accuWeather


import com.google.gson.annotations.SerializedName
import com.karan.lilcloud.model.accuWeather.SearchResponse.SearchResponseItem

class SearchResponse : ArrayList<SearchResponseItem>(){
    data class SearchResponseItem(
        @SerializedName("AdministrativeArea")
        val administrativeArea: AdministrativeArea?,
        @SerializedName("Country")
        val country: Country?,
        @SerializedName("Key")
        val key: String?,
        @SerializedName("LocalizedName")
        val localizedName: String?,
        @SerializedName("Rank")
        val rank: Int?,
        @SerializedName("Type")
        val type: String?,
        @SerializedName("Version")
        val version: Int?
    ) {
        data class AdministrativeArea(
            @SerializedName("ID")
            val iD: String?,
            @SerializedName("LocalizedName")
            val localizedName: String?
        )
    
        data class Country(
            @SerializedName("ID")
            val iD: String?,
            @SerializedName("LocalizedName")
            val localizedName: String?
        )
    }
}
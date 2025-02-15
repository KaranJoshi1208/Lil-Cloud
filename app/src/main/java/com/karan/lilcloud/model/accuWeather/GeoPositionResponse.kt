package com.karan.lilcloud.model.accuWeather


import com.google.gson.annotations.SerializedName

data class GeoPositionResponse(
    @SerializedName("AdministrativeArea")
    val administrativeArea: AdministrativeArea?,
    @SerializedName("Country")
    val country: Country?,
    @SerializedName("DataSets")
    val dataSets: List<String?>?,
    @SerializedName("EnglishName")
    val englishName: String?,
    @SerializedName("GeoPosition")
    val geoPosition: GeoPosition?,
    @SerializedName("IsAlias")
    val isAlias: Boolean?,
    @SerializedName("Key")
    val key: String?,
    @SerializedName("LocalizedName")
    val localizedName: String?,
    @SerializedName("ParentCity")
    val parentCity: ParentCity?,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String?,
    @SerializedName("Rank")
    val rank: Int?,
    @SerializedName("Region")
    val region: Region?,
    @SerializedName("SupplementalAdminAreas")
    val supplementalAdminAreas: List<Any?>?,
    @SerializedName("TimeZone")
    val timeZone: TimeZone?,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("Version")
    val version: Int?
) {
    data class AdministrativeArea(
        @SerializedName("CountryID")
        val countryID: String?,
        @SerializedName("EnglishName")
        val englishName: String?,
        @SerializedName("EnglishType")
        val englishType: String?,
        @SerializedName("ID")
        val iD: String?,
        @SerializedName("Level")
        val level: Int?,
        @SerializedName("LocalizedName")
        val localizedName: String?,
        @SerializedName("LocalizedType")
        val localizedType: String?
    )

    data class Country(
        @SerializedName("EnglishName")
        val englishName: String?,
        @SerializedName("ID")
        val iD: String?,
        @SerializedName("LocalizedName")
        val localizedName: String?
    )

    data class GeoPosition(
        @SerializedName("Elevation")
        val elevation: Elevation?,
        @SerializedName("Latitude")
        val latitude: Double?,
        @SerializedName("Longitude")
        val longitude: Double?
    ) {
        data class Elevation(
            @SerializedName("Imperial")
            val imperial: Imperial?,
            @SerializedName("Metric")
            val metric: Metric?
        ) {
            data class Imperial(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class Metric(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )
        }
    }

    data class ParentCity(
        @SerializedName("EnglishName")
        val englishName: String?,
        @SerializedName("Key")
        val key: String?,
        @SerializedName("LocalizedName")
        val localizedName: String?
    )

    data class Region(
        @SerializedName("EnglishName")
        val englishName: String?,
        @SerializedName("ID")
        val iD: String?,
        @SerializedName("LocalizedName")
        val localizedName: String?
    )

    data class TimeZone(
        @SerializedName("Code")
        val code: String?,
        @SerializedName("GmtOffset")
        val gmtOffset: Double?,
        @SerializedName("IsDaylightSaving")
        val isDaylightSaving: Boolean?,
        @SerializedName("Name")
        val name: String?,
        @SerializedName("NextOffsetChange")
        val nextOffsetChange: Any?
    )
}
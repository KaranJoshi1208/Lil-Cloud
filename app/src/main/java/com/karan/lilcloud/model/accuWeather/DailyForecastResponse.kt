package com.karan.lilcloud.model.accuWeather


import com.google.gson.annotations.SerializedName

data class DailyForecastResponse(
    @SerializedName("DailyForecasts")
    val dailyForecasts: List<DailyForecast?>?,
//    @SerializedName("Headline")
//    val headline: Headline?
) {
    data class DailyForecast(
        @SerializedName("AirAndPollen")
        val airAndPollen: List<AirAndPollen?>?,
//        @SerializedName("Date")
//        val date: String?,
//        @SerializedName("Day")
//        val day: Day?,
//        @SerializedName("DegreeDaySummary")
//        val degreeDaySummary: DegreeDaySummary?,
//        @SerializedName("EpochDate")
//        val epochDate: Int?,
//        @SerializedName("HoursOfSun")
//        val hoursOfSun: Double?,
//        @SerializedName("Link")
//        val link: String?,
//        @SerializedName("MobileLink")
//        val mobileLink: String?,
//        @SerializedName("Moon")
//        val moon: Moon?,
//        @SerializedName("Night")
//        val night: Night?,
//        @SerializedName("RealFeelTemperature")
//        val realFeelTemperature: RealFeelTemperature?,
//        @SerializedName("RealFeelTemperatureShade")
//        val realFeelTemperatureShade: RealFeelTemperatureShade?,
        @SerializedName("Sources")
        val sources: List<String?>?,
        @SerializedName("Sun")
        val sun: Sun?,
//        @SerializedName("Temperature")
//        val temperature: Temperature?
    ) {
        data class AirAndPollen(
            @SerializedName("Category")
            val category: String?,
            @SerializedName("CategoryValue")
            val categoryValue: Int?,
            @SerializedName("Name")
            val name: String?,
            @SerializedName("Type")
            val type: String?,
            @SerializedName("Value")
            val value: Int?
        )

        data class Day(
            @SerializedName("CloudCover")
            val cloudCover: Int?,
            @SerializedName("Evapotranspiration")
            val evapotranspiration: Evapotranspiration?,
            @SerializedName("HasPrecipitation")
            val hasPrecipitation: Boolean?,
            @SerializedName("HoursOfIce")
            val hoursOfIce: Int?,
            @SerializedName("HoursOfPrecipitation")
            val hoursOfPrecipitation: Double?,
            @SerializedName("HoursOfRain")
            val hoursOfRain: Double?,
            @SerializedName("HoursOfSnow")
            val hoursOfSnow: Int?,
            @SerializedName("Ice")
            val ice: Ice?,
            @SerializedName("IceProbability")
            val iceProbability: Int?,
            @SerializedName("Icon")
            val icon: Int?,
            @SerializedName("IconPhrase")
            val iconPhrase: String?,
            @SerializedName("LongPhrase")
            val longPhrase: String?,
            @SerializedName("PrecipitationIntensity")
            val precipitationIntensity: String?,
            @SerializedName("PrecipitationProbability")
            val precipitationProbability: Int?,
            @SerializedName("PrecipitationType")
            val precipitationType: String?,
            @SerializedName("Rain")
            val rain: Rain?,
            @SerializedName("RainProbability")
            val rainProbability: Int?,
            @SerializedName("RelativeHumidity")
            val relativeHumidity: RelativeHumidity?,
            @SerializedName("ShortPhrase")
            val shortPhrase: String?,
            @SerializedName("Snow")
            val snow: Snow?,
            @SerializedName("SnowProbability")
            val snowProbability: Int?,
            @SerializedName("SolarIrradiance")
            val solarIrradiance: SolarIrradiance?,
            @SerializedName("ThunderstormProbability")
            val thunderstormProbability: Int?,
            @SerializedName("TotalLiquid")
            val totalLiquid: TotalLiquid?,
            @SerializedName("WetBulbGlobeTemperature")
            val wetBulbGlobeTemperature: WetBulbGlobeTemperature?,
//            @SerializedName("WetBulbTemperature")
//            val wetBulbTemperature: WetBulbTemperature?,
            @SerializedName("Wind")
            val wind: Wind?,
            @SerializedName("WindGust")
            val windGust: WindGust?
        ) {
            data class Evapotranspiration(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class Ice(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class Rain(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class RelativeHumidity(
                @SerializedName("Average")
                val average: Int?,
                @SerializedName("Maximum")
                val maximum: Int?,
                @SerializedName("Minimum")
                val minimum: Int?
            )

            data class Snow(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class SolarIrradiance(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class TotalLiquid(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class WetBulbGlobeTemperature(
                @SerializedName("Average")
                val average: Average?,
                @SerializedName("Maximum")
                val maximum: Maximum?,
                @SerializedName("Minimum")
                val minimum: Minimum?
            ) {
                data class Average(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Int?
                )

                data class Maximum(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )

                data class Minimum(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )
            }

            data class WetBulbTemperature(
                @SerializedName("Average")
                val average: Average?,
                @SerializedName("Maximum")
                val maximum: Maximum?,
                @SerializedName("Minimum")
                val minimum: Minimum?
            ) {
                data class Average(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )

                data class Maximum(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Int?
                )

                data class Minimum(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )
            }

            data class Wind(
                @SerializedName("Direction")
                val direction: Direction?,
                @SerializedName("Speed")
                val speed: Speed?
            ) {
                data class Direction(
                    @SerializedName("Degrees")
                    val degrees: Int?,
                    @SerializedName("English")
                    val english: String?,
                    @SerializedName("Localized")
                    val localized: String?
                )

                data class Speed(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )
            }

            data class WindGust(
                @SerializedName("Direction")
                val direction: Direction?,
                @SerializedName("Speed")
                val speed: Speed?
            ) {
                data class Direction(
                    @SerializedName("Degrees")
                    val degrees: Int?,
                    @SerializedName("English")
                    val english: String?,
                    @SerializedName("Localized")
                    val localized: String?
                )

                data class Speed(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )
            }
        }

        data class DegreeDaySummary(
            @SerializedName("Cooling")
            val cooling: Cooling?,
            @SerializedName("Heating")
            val heating: Heating?
        ) {
            data class Cooling(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class Heating(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )
        }

        data class Moon(
            @SerializedName("Age")
            val age: Int?,
            @SerializedName("EpochRise")
            val epochRise: Int?,
            @SerializedName("EpochSet")
            val epochSet: Int?,
            @SerializedName("Phase")
            val phase: String?,
            @SerializedName("Rise")
            val rise: String?,
            @SerializedName("Set")
            val `set`: String?
        )

        data class Night(
            @SerializedName("CloudCover")
            val cloudCover: Int?,
            @SerializedName("Evapotranspiration")
            val evapotranspiration: Evapotranspiration?,
            @SerializedName("HasPrecipitation")
            val hasPrecipitation: Boolean?,
            @SerializedName("HoursOfIce")
            val hoursOfIce: Int?,
            @SerializedName("HoursOfPrecipitation")
            val hoursOfPrecipitation: Int?,
            @SerializedName("HoursOfRain")
            val hoursOfRain: Int?,
            @SerializedName("HoursOfSnow")
            val hoursOfSnow: Int?,
            @SerializedName("Ice")
            val ice: Ice?,
            @SerializedName("IceProbability")
            val iceProbability: Int?,
            @SerializedName("Icon")
            val icon: Int?,
            @SerializedName("IconPhrase")
            val iconPhrase: String?,
            @SerializedName("LongPhrase")
            val longPhrase: String?,
            @SerializedName("PrecipitationProbability")
            val precipitationProbability: Int?,
            @SerializedName("Rain")
            val rain: Rain?,
            @SerializedName("RainProbability")
            val rainProbability: Int?,
            @SerializedName("RelativeHumidity")
            val relativeHumidity: RelativeHumidity?,
            @SerializedName("ShortPhrase")
            val shortPhrase: String?,
            @SerializedName("Snow")
            val snow: Snow?,
            @SerializedName("SnowProbability")
            val snowProbability: Int?,
            @SerializedName("SolarIrradiance")
            val solarIrradiance: SolarIrradiance?,
            @SerializedName("ThunderstormProbability")
            val thunderstormProbability: Int?,
            @SerializedName("TotalLiquid")
            val totalLiquid: TotalLiquid?,
            @SerializedName("WetBulbGlobeTemperature")
            val wetBulbGlobeTemperature: WetBulbGlobeTemperature?,
            @SerializedName("WetBulbTemperature")
            val wetBulbTemperature: WetBulbTemperature?,
            @SerializedName("Wind")
            val wind: Wind?,
            @SerializedName("WindGust")
            val windGust: WindGust?
        ) {
            data class Evapotranspiration(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class Ice(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class Rain(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class RelativeHumidity(
                @SerializedName("Average")
                val average: Int?,
                @SerializedName("Maximum")
                val maximum: Int?,
                @SerializedName("Minimum")
                val minimum: Int?
            )

            data class Snow(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class SolarIrradiance(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class TotalLiquid(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Int?
            )

            data class WetBulbGlobeTemperature(
                @SerializedName("Average")
                val average: Average?,
                @SerializedName("Maximum")
                val maximum: Maximum?,
                @SerializedName("Minimum")
                val minimum: Minimum?
            ) {
                data class Average(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Int?
                )

                data class Maximum(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )

                data class Minimum(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )
            }

            data class WetBulbTemperature(
                @SerializedName("Average")
                val average: Average?,
                @SerializedName("Maximum")
                val maximum: Maximum?,
                @SerializedName("Minimum")
                val minimum: Minimum?
            ) {
                data class Average(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )

                data class Maximum(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )

                data class Minimum(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )
            }

            data class Wind(
                @SerializedName("Direction")
                val direction: Direction?,
                @SerializedName("Speed")
                val speed: Speed?
            ) {
                data class Direction(
                    @SerializedName("Degrees")
                    val degrees: Int?,
                    @SerializedName("English")
                    val english: String?,
                    @SerializedName("Localized")
                    val localized: String?
                )

                data class Speed(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )
            }

            data class WindGust(
                @SerializedName("Direction")
                val direction: Direction?,
                @SerializedName("Speed")
                val speed: Speed?
            ) {
                data class Direction(
                    @SerializedName("Degrees")
                    val degrees: Int?,
                    @SerializedName("English")
                    val english: String?,
                    @SerializedName("Localized")
                    val localized: String?
                )

                data class Speed(
                    @SerializedName("Unit")
                    val unit: String?,
                    @SerializedName("UnitType")
                    val unitType: Int?,
                    @SerializedName("Value")
                    val value: Double?
                )
            }
        }

        data class RealFeelTemperature(
            @SerializedName("Maximum")
            val maximum: Maximum?,
            @SerializedName("Minimum")
            val minimum: Minimum?
        ) {
            data class Maximum(
                @SerializedName("Phrase")
                val phrase: String?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class Minimum(
                @SerializedName("Phrase")
                val phrase: String?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )
        }

        data class RealFeelTemperatureShade(
            @SerializedName("Maximum")
            val maximum: Maximum?,
            @SerializedName("Minimum")
            val minimum: Minimum?
        ) {
            data class Maximum(
                @SerializedName("Phrase")
                val phrase: String?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class Minimum(
                @SerializedName("Phrase")
                val phrase: String?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )
        }

        data class Sun(
            @SerializedName("EpochRise")
            val epochRise: Int?,
            @SerializedName("EpochSet")
            val epochSet: Int?,
            @SerializedName("Rise")
            val rise: String?,
            @SerializedName("Set")
            val `set`: String?
        )

        data class Temperature(
            @SerializedName("Maximum")
            val maximum: Maximum?,
            @SerializedName("Minimum")
            val minimum: Minimum?
        ) {
            data class Maximum(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class Minimum(
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )
        }
    }

    data class Headline(
        @SerializedName("Category")
        val category: String?,
        @SerializedName("EffectiveDate")
        val effectiveDate: String?,
        @SerializedName("EffectiveEpochDate")
        val effectiveEpochDate: Int?,
        @SerializedName("EndDate")
        val endDate: String?,
        @SerializedName("EndEpochDate")
        val endEpochDate: Int?,
        @SerializedName("Link")
        val link: String?,
        @SerializedName("MobileLink")
        val mobileLink: String?,
        @SerializedName("Severity")
        val severity: Int?,
        @SerializedName("Text")
        val text: String?
    )
}
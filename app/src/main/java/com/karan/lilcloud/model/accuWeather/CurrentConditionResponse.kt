package com.karan.lilcloud.model.accuWeather


import com.google.gson.annotations.SerializedName
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem

class CurrentConditionResponse : ArrayList<CurrentConditionResponseItem>(){
    data class CurrentConditionResponseItem(
        @SerializedName("Ceiling")
        val ceiling: Ceiling?,
        @SerializedName("CloudCover")
        val cloudCover: Int?,
        @SerializedName("DewPoint")
        val dewPoint: DewPoint?,
        @SerializedName("EpochTime")
        val epochTime: Int?,
        @SerializedName("HasPrecipitation")
        val hasPrecipitation: Boolean?,
        @SerializedName("IsDayTime")
        val isDayTime: Boolean?,
        @SerializedName("Link")
        val link: String?,
        @SerializedName("MobileLink")
        val mobileLink: String?,
        @SerializedName("Precip1hr")
        val precip1hr: Precip1hr?,
        @SerializedName("PrecipitationType")
        val precipitationType: Any?,
        @SerializedName("Pressure")
        val pressure: Pressure?,
        @SerializedName("RealFeelTemperature")
        val realFeelTemperature: RealFeelTemperature?,
        @SerializedName("RelativeHumidity")
        val relativeHumidity: Int?,
        @SerializedName("Temperature")
        val temperature: Temperature?,
        @SerializedName("TemperatureSummary")
        val temperatureSummary: TemperatureSummary?,
        @SerializedName("UVIndex")
        val uVIndex: Int?,
        @SerializedName("UVIndexText")
        val uVIndexText: String?,
        @SerializedName("Visibility")
        val visibility: Visibility?,
        @SerializedName("WeatherIcon")
        val weatherIcon: Int?,
        @SerializedName("WeatherText")
        val weatherText: String?,
        @SerializedName("Wind")
        val wind: Wind?,
        @SerializedName("WindGust")
        val windGust: WindGust?
    ) {
        data class Ceiling(
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

        data class DewPoint(
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

        data class Precip1hr(
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

        data class Pressure(
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

        data class RealFeelTemperature(
            @SerializedName("Imperial")
            val imperial: Imperial?,
            @SerializedName("Metric")
            val metric: Metric?
        ) {
            data class Imperial(
                @SerializedName("Phrase")
                val phrase: String?,
                @SerializedName("Unit")
                val unit: String?,
                @SerializedName("UnitType")
                val unitType: Int?,
                @SerializedName("Value")
                val value: Double?
            )

            data class Metric(
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

        data class Temperature(
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

        data class TemperatureSummary(
            @SerializedName("Past12HourRange")
            val past12HourRange: Past12HourRange?,
            @SerializedName("Past24HourRange")
            val past24HourRange: Past24HourRange?,
            @SerializedName("Past6HourRange")
            val past6HourRange: Past6HourRange?
        ) {
            data class Past12HourRange(
                @SerializedName("Maximum")
                val maximum: Maximum?,
                @SerializedName("Minimum")
                val minimum: Minimum?
            ) {
                data class Maximum(
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

                data class Minimum(
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

            data class Past24HourRange(
                @SerializedName("Maximum")
                val maximum: Maximum?,
                @SerializedName("Minimum")
                val minimum: Minimum?
            ) {
                data class Maximum(
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

                data class Minimum(
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

            data class Past6HourRange(
                @SerializedName("Maximum")
                val maximum: Maximum?,
                @SerializedName("Minimum")
                val minimum: Minimum?
            ) {
                data class Maximum(
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

                data class Minimum(
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
        }

        data class Visibility(
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

        data class WindGust(
            @SerializedName("Speed")
            val speed: Speed?
        ) {
            data class Speed(
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
    }
}
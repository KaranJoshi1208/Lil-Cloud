package com.karan.lilcloud.model.accuWeather


import com.google.gson.annotations.SerializedName

class CurrentConditiion : ArrayList<CurrentConditiionItem>(){
    data class CurrentConditiionItem(
        @SerializedName("ApparentTemperature")
        val apparentTemperature: ApparentTemperature?,
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
        @SerializedName("IndoorRelativeHumidity")
        val indoorRelativeHumidity: Int?,
        @SerializedName("IsDayTime")
        val isDayTime: Boolean?,
        @SerializedName("Link")
        val link: String?,
        @SerializedName("LocalObservationDateTime")
        val localObservationDateTime: String?,
        @SerializedName("MobileLink")
        val mobileLink: String?,
        @SerializedName("ObstructionsToVisibility")
        val obstructionsToVisibility: String?,
        @SerializedName("Past24HourTemperatureDeparture")
        val past24HourTemperatureDeparture: Past24HourTemperatureDeparture?,
        @SerializedName("Precip1hr")
        val precip1hr: Precip1hr?,
        @SerializedName("PrecipitationSummary")
        val precipitationSummary: PrecipitationSummary?,
        @SerializedName("PrecipitationType")
        val precipitationType: Any?,
        @SerializedName("Pressure")
        val pressure: Pressure?,
        @SerializedName("PressureTendency")
        val pressureTendency: PressureTendency?,
        @SerializedName("RealFeelTemperature")
        val realFeelTemperature: RealFeelTemperature?,
        @SerializedName("RealFeelTemperatureShade")
        val realFeelTemperatureShade: RealFeelTemperatureShade?,
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
        @SerializedName("WetBulbGlobeTemperature")
        val wetBulbGlobeTemperature: WetBulbGlobeTemperature?,
        @SerializedName("WetBulbTemperature")
        val wetBulbTemperature: WetBulbTemperature?,
        @SerializedName("Wind")
        val wind: Wind?,
        @SerializedName("WindChillTemperature")
        val windChillTemperature: WindChillTemperature?,
        @SerializedName("WindGust")
        val windGust: WindGust?
    ) {
        data class ApparentTemperature(
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
    
        data class Past24HourTemperatureDeparture(
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
    
        data class PrecipitationSummary(
            @SerializedName("Past12Hours")
            val past12Hours: Past12Hours?,
            @SerializedName("Past18Hours")
            val past18Hours: Past18Hours?,
            @SerializedName("Past24Hours")
            val past24Hours: Past24Hours?,
            @SerializedName("Past3Hours")
            val past3Hours: Past3Hours?,
            @SerializedName("Past6Hours")
            val past6Hours: Past6Hours?,
            @SerializedName("Past9Hours")
            val past9Hours: Past9Hours?,
            @SerializedName("PastHour")
            val pastHour: PastHour?,
            @SerializedName("Precipitation")
            val precipitation: Precipitation?
        ) {
            data class Past12Hours(
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
    
            data class Past18Hours(
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
    
            data class Past24Hours(
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
    
            data class Past3Hours(
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
    
            data class Past6Hours(
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
    
            data class Past9Hours(
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
    
            data class PastHour(
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
    
            data class Precipitation(
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
    
        data class PressureTendency(
            @SerializedName("Code")
            val code: String?,
            @SerializedName("LocalizedText")
            val localizedText: String?
        )
    
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
    
        data class RealFeelTemperatureShade(
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
    
        data class WetBulbGlobeTemperature(
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
    
        data class WetBulbTemperature(
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
    
        data class WindChillTemperature(
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
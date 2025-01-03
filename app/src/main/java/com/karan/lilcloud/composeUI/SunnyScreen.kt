package com.karan.lilcloud.composeUI

import android.app.Application
import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.Ceiling
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.Ceiling.Imperial
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.DewPoint
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.Precip1hr
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.Pressure
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.RealFeelTemperature
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.Temperature
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.Temperature.Metric
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.TemperatureSummary
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.TemperatureSummary.Past12HourRange
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.TemperatureSummary.Past12HourRange.Minimum
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.TemperatureSummary.Past24HourRange
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.TemperatureSummary.Past24HourRange.Maximum
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.TemperatureSummary.Past6HourRange
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.Visibility
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.Wind
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse.CurrentConditionResponseItem.WindGust
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse.AdministrativeArea
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse.ParentCity
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse.Region
import com.karan.lilcloud.model.accuWeather.GeoPositionResponse.TimeZone
import com.karan.lilcloud.ui.theme.LilCloudTheme
import com.karan.lilcloud.viewModel.WeatherViewModel
import kotlin.math.roundToInt


@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel,
    modifier: Modifier = Modifier /* getBg : () -> Int */
) {

    if (viewModel.showDialog.value) {
        EnableLocationDialog(
            { viewModel.showLocationSettings() },
            { viewModel.showDialog.value = false }
        )
    }

    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF152FB2), Color(0xFF03A9F4))
                )
            )
            .then(modifier),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(enabled = true, state = scrollState)

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.menu),
                    contentDescription = "Menu",
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .size(32.dp),
                )
            }

            viewModel.currentCondition.value?.let {
                WeatherInfo(viewModel, Modifier)
            } ?: if (viewModel.showLoading.value) Loading() else {/* TODO("Screen to show select city manually")*/ }
        }
    }
}

@Composable
fun WeatherInfo(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {

    val weather = viewModel.currentCondition.value
    val location = viewModel.geoLocation.value

    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = location?.localizedName?.toString() ?: "where ?",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(1f, 1f),
                        blurRadius = 2.5f
                    )
                )
            )
        }

        Text(
            text = " " + weather?.temperature?.metric?.value?.roundToInt() + "°",
            fontSize = 100.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black, offset = Offset(1f, 1f), blurRadius = 2.5f
                )
            )
        )
        val temp = weather?.temperatureSummary?.past6HourRange

        Text(
            text = "${temp?.maximum?.metric?.value.toString()}° / ${temp?.minimum?.metric?.value.toString()}°",
            fontSize = 16.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
        )

        Text(
            text = weather?.weatherText.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
        )
    }
}

@Composable
fun WeatherDetails(scrollState: ScrollState, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState, enabled = true)
            .then(modifier)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ,
            colors = CardDefaults.cardColors(
                containerColor = Color(0x08FFFFFF),

            ),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(12.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .weight(0.8f)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.windy),
                        contentDescription = "Weather Icon",
                        modifier = Modifier.size(120.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row {
                        Text(
                            text = "23",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                        Text(
                            text = " / ",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "17",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.8f)
                        .padding(start = 16.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    InfoElement(
                        name = "Humidity",
                        value = "34" + "%"
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF))
                        ,
                    )

                    InfoElement(
                        name = "Real Feel",
                        value = "12" + "°C"
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF))
                        ,
                    )

                    InfoElement(
                        name = "UV Index",
                        value = "2"
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF))
                        ,
                    )

                    InfoElement(
                        name = "Pressure",
                        value = "1015" + " mbar"
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF))
                        ,
                    )

                    InfoElement(
                        name = "Chances of Rain",
                        value = "4" + "%"
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF))
                        ,
                    )
                }
            }
        }
    }
}

@Composable
fun Wind() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 72.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
//                .height(200.dp)
                .padding(16.dp)
            ,
            colors = CardDefaults.cardColors(
                containerColor = Color(0x08FFFFFF),
                ),

        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(start = 16.dp, bottom = 12.dp)
                    ,

                ) {
                    Text(
                        text = "Wind",
//                        fontWeight = FontWeight.,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    InfoElement(
                        name = "Speed",
                        value = "12.7" + " Km/h"
                    )
                    InfoElement(
                        name = "Direction",
                        value = "ESE"
                    )

                    InfoElement(
                        name = "Degrees",
                        value = "113" + "°"
                    )

                    InfoElement(
                        name = "Gust Speed",
                        value = "23.7" + " Km/h"
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(130.dp)
                            .clip(shape = CircleShape)
                            .border(width = 3.dp, color = Color.Black, shape = CircleShape)

                    ) {
                        // Compass directions
                        Text(
                            text = "N",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 4.dp),
                            color = Color(0xFF8B0000)
                        )
                        Text(
                            text = "E",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 10.dp),
                            color = Color.White
                        )
                        Text(
                            text = "S",
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 4.dp),
                            color = Color.Black
                        )
                        Text(
                            text = "W",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 8.dp),
                            color = Color.White
                        )

                        // Needle (arrow)

                        Box(
                            modifier = Modifier
                                .padding(30.dp)
                                .fillMaxSize()
                                .clip(CircleShape)
                            ,
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxHeight(0.7f)
                                    .width(2.dp)
                                    .background(Color(0xFFFFD700))
                                ,

                            )
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Black)
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EnableLocationDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(text = "Location Services")
        },
        text = {
            Text(text = "Location services are required to show weather, please enable them.")
        },
        confirmButton = {
            Text(
                text = "Go to Settings",
                color = Color.Blue,
                modifier = Modifier
                    .clickable(enabled = true, onClick = { onConfirm() })
            )
        },
        dismissButton = {
            Text(
                text = "Cancel",
                color = Color.Blue,
                modifier = Modifier
                    .clickable(enabled = true, onClick = { onDismiss() })
                    .padding(end = 36.dp)
            )
        },
    )
}


@Composable
fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x40000000))
                .blur(radius = 20.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 104.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            androidx.compose.material3.CircularProgressIndicator(
                color = Color.White,
                strokeWidth = 4.dp,
                modifier = Modifier
                    .size(100.dp)
            )
        }
    }
}

@Composable
fun InfoElement(name : String = "", value : String = "") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
        ,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Text(
            text = name,
            fontSize = 12.sp,
            color = Color(0x50FFFFFF),
        )
        Text(
            text = value,
            fontSize = 12.sp,
            color = Color(0x80FFFFFF),
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SunnyPreview() {
    LilCloudTheme {
//        WeatherScreen(FakeWeatherViewModel())
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF152FB2),
                            Color(0xFF03A9F4))
                    )
                )
        ) {
            WeatherDetails(rememberScrollState(0), Modifier.padding(top = 72.dp))
//            Wind()
        }
    }
}


class FakeWeatherViewModel : WeatherViewModel(Application()) {
    init {

        showDialog.value = false
        showLoading.value = false
        // Mock data
        currentCondition.value = CurrentConditionResponseItem(
            ceiling = Ceiling(
                imperial = Imperial(unit = "ft", unitType = 0, value = 30000.0),
                metric = Ceiling.Metric(unit = "m", unitType = 5, value = 9144.0)
            ),
            cloudCover = 51,
            dewPoint = DewPoint(
                imperial = DewPoint.Imperial(unit = "F", unitType = 18, value = 43.0),
                metric = DewPoint.Metric(unit = "C", unitType = 17, value = 6.2)
            ),
            epochTime = 1734602220,
            hasPrecipitation = false,
            isDayTime = true,
            link = "http://www.accuweather.com/en/in/dwarka/3588465/current-weather/3588465?lang=en-us",
            mobileLink = "http://www.accuweather.com/en/in/dwarka/3588465/current-weather/3588465?lang=en-us",
            precip1hr = Precip1hr(
                imperial = Precip1hr.Imperial(unit = "in", unitType = 1, value = 0.0),
                metric = Precip1hr.Metric(unit = "mm", unitType = 3, value = 0.0)
            ),
            precipitationType = null,
            pressure = Pressure(
                imperial = Pressure.Imperial(unit = "inHg", unitType = 12, value = 29.97),
                metric = Pressure.Metric(unit = "mb", unitType = 14, value = 1015.0)
            ),
            realFeelTemperature = RealFeelTemperature(
                imperial = RealFeelTemperature.Imperial(phrase = "Pleasant", unit = "F", unitType = 18, value = 73.0),
                metric = RealFeelTemperature.Metric(phrase = "Pleasant", unit = "C", unitType = 17, value = 22.9)
            ),
            relativeHumidity = 34,
            temperature = Temperature(
                imperial = Temperature.Imperial(unit = "F", unitType = 18, value = 73.0),
                metric = Metric(unit = "C", unitType = 17, value = 22.9)
            ),
            temperatureSummary = TemperatureSummary(
                past12HourRange = Past12HourRange(
                    maximum = Past12HourRange.Maximum(
                        imperial = Past12HourRange.Maximum.Imperial(unit = "F", unitType = 18, value = 73.0),
                        metric = Past12HourRange.Maximum.Metric(unit = "C", unitType = 17, value = 22.9)
                    ),
                    minimum = Minimum(
                        imperial = Minimum.Imperial(unit = "F", unitType = 18, value = 46.0),
                        metric = Minimum.Metric(unit = "C", unitType = 17, value = 8.0)
                    )
                ),
                past24HourRange = Past24HourRange(
                    maximum = Maximum(
                        imperial = Maximum.Imperial(unit = "F", unitType = 18, value = 77.0),
                        metric = Maximum.Metric(unit = "C", unitType = 17, value = 24.8)
                    ),
                    minimum = Past24HourRange.Minimum(
                        imperial = Past24HourRange.Minimum.Imperial(unit = "F", unitType = 18, value = 46.0),
                        metric = Past24HourRange.Minimum.Metric(unit = "C", unitType = 17, value = 8.0)
                    )
                ),
                past6HourRange = Past6HourRange(
                    maximum = Past6HourRange.Maximum(
                        imperial = Past6HourRange.Maximum.Imperial(unit = "F", unitType = 18, value = 73.0),
                        metric = Past6HourRange.Maximum.Metric(unit = "C", unitType = 17, value = 22.9)
                    ),
                    minimum = Past6HourRange.Minimum(
                        imperial = Past6HourRange.Minimum.Imperial(unit = "F", unitType = 18, value = 52.0),
                        metric = Past6HourRange.Minimum.Metric(unit = "C", unitType = 17, value = 11.2)
                    )
                )
            ),
            uVIndex = 2,
            uVIndexText = "Low",
            visibility = Visibility(
                imperial = Visibility.Imperial(unit = "mi", unitType = 2, value = 4.0),
                metric = Visibility.Metric(unit = "km", unitType = 6, value = 6.4)
            ),
            weatherIcon = 5,
            weatherText = "Hazy sunshine",
            wind = Wind(
                direction = Wind.Direction(degrees = 113, english = "ESE", localized = "ESE"),
                speed = Wind.Speed(
                    imperial = Wind.Speed.Imperial(unit = "mi/h", unitType = 9, value = 7.4),
                    metric = Wind.Speed.Metric(unit = "km/h", unitType = 7, value = 12.0)
                )
            ),
            windGust = WindGust(
                speed = WindGust.Speed(
                    imperial = WindGust.Speed.Imperial(unit = "mi/h", unitType = 9, value = 14.7),
                    metric = WindGust.Speed.Metric(unit = "km/h", unitType = 7, value = 23.7)
                )
            )
        )

        geoLocation.value = GeoPositionResponse(
            administrativeArea = AdministrativeArea(
                countryID = "IN",
                englishName = "Delhi",
                englishType = "Union Territory",
                iD = "DL",
                level = 1,
                localizedName = "Delhi",
                localizedType = "Union Territory"
            ),
            country = null,
            dataSets = null,
            englishName = "Dwarka",
            geoPosition = null,
            isAlias = false,
            key = "3588465",
            localizedName = "Dwarka",
            parentCity = ParentCity(englishName = "Delhi", key = "202396", localizedName = "Delhi"),
            primaryPostalCode = null,
            rank = 45,
            region = Region(englishName = "Asia", iD = "ASI", localizedName = "Asia"),
            supplementalAdminAreas = null,
            timeZone = TimeZone(
                code = "IST",
                gmtOffset = 5.5,
                isDaylightSaving = false,
                name = "Asia / Kolkata",
                nextOffsetChange = null
            ),
            type = "City",
            version = 1
        )
    }
}
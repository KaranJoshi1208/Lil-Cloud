package com.karan.lilcloud.composeUI

import android.app.Application
import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
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

//    if (viewModel.showDialog.value) {
//        EnableLocationDialog(
//            { viewModel.showLocationSettings() },
//            { viewModel.showDialog.value = false }
//        )
//    }

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
//            .background(color = Color.Transparent)
            .verticalScroll(scrollState, enabled = true)
            .then(modifier)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Hellow CAT !!!")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ,
            colors = CardDefaults.cardColors(
                containerColor = Color(0x08FFFFFF),

            )
//            elevation = CardElevation(),
//            shape = MaterialTheme.shapes.medium
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .blur(12.dp)
                ,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Weather icon (use Image or an icon URL)
                Image(
                    painter = painterResource(id = R.drawable.cloudy_sunny),
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(64.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Temperatures
                Text(
                    text = "23°C",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Description
                Text(
                    text = "weatherData.description",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Spacer(modifier = Modifier
                    .height(16.dp)
                )

                // Weather details (Humidity, Wind Speed)
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

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
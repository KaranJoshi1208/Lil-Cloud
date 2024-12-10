package com.karan.lilcloud.composeUI

import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.karan.lilcloud.model.Weather
import com.karan.lilcloud.model.Weather.Clouds
import com.karan.lilcloud.model.Weather.Coord
import com.karan.lilcloud.model.Weather.Main
import com.karan.lilcloud.model.Weather.Sys
import com.karan.lilcloud.model.Weather.Wind
import com.karan.lilcloud.ui.theme.LilCloudTheme
import kotlin.math.roundToInt


@Composable
fun WeatherScreen(weather: Weather?, modifier: Modifier = Modifier /* getBg : () -> Int */) {

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
        /**
         * Blur the background
         */

//        Box(
//            modifier = Modifier
//                .matchParentSize()
//                .background(Color.Transparent) // Semi-transparent white
//                .blur(radius = 16.dp) // Blur only the background
//        )

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
                        .size(32.dp)
                )
            }
            weather?.let {
                WeatherDetail(weather, Modifier)
            }
        }
    }
}

@Composable
fun WeatherDetail(weather: Weather, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = weather.name?.toString() ?: "Select City",
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth(),
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
            text = " " + weather.main?.temp?.roundToInt() + "°",
            fontSize = 100.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black, offset = Offset(1f, 1f), blurRadius = 2.5f
                )
            )
        )

        Text(
            text = "30° / 16°",
            fontSize = 16.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
        )

        Text(
            text = "Clear Sky",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SunnyPreview() {

    val dummyWeather1 = Weather(
        base = null,
        clouds = null,
        cod = null,
        coord = null,
        dt = null,
        id = null,
        main = null,
        name = null,
        rain = null,
        sys = null,
        timezone = null,
        visibility = null,
        weather = null,
        wind = null
    )

    val dummyWeather2: Weather? = null
    val dummyWeather3 = Weather(
        base = "stations",
        clouds = Clouds(all = 0),
        cod = 200,
        coord = Coord(lat = 30.3165, lon = 78.0322),
        dt = 1731842075,
        id = 1273313,
        main = Main(
            feelsLike = 23.88,
            grndLevel = 925,
            humidity = 41,
            pressure = 1013,
            seaLevel = 1013,
            temp = 24.32,
            tempMax = 24.32,
            tempMin = 24.32
        ),
        name = "Dehra Dūn",
        rain = null,
        sys = Sys(country = "IN", id = 9162, sunrise = 1731806124, sunset = 1731844236, type = 1),
        timezone = 19800,
        visibility = 10000,
        weather = null /* listOf( Weather(description= "clear sky", icon="01n", id=800, main="Clear")) */,
        wind = Wind(deg = 281, gust = 1.52, speed = 1.45)
    )
    LilCloudTheme {
        WeatherScreen(
            dummyWeather3
        )
    }
}
package com.karan.lilcloud.composeUI

import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karan.lilcloud.model.Weather
import com.karan.lilcloud.ui.theme.LilCloudTheme


@Composable
fun WeatherScreen(weather: Weather, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
        ,
    ) {
        Image(
            painter = painterResource(id = R.drawable.sunny_bg),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize()

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 64.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = weather.name.toString(),
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp),
//                    style = TextStyle(shadow = Shadow(color = Color.Black, offset = Offset(1f,1f) , blurRadius = 2.5f))
                )

                Image(
                    painter = painterResource(id = R.drawable.plus),
                    contentDescription = "Add City",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 16.dp)
                )
            }
            WeatherDetail(weather, Modifier)

        }
    }


}

@Composable
fun WeatherDetail(weather : Weather, modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier
            .padding(top = 32.dp)
            .fillMaxWidth()
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {


        Column(
            modifier = Modifier
//                        .padding(horizontal = 16.dp)
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(60.dp),
            )

            Text(
                text = weather.wind?.speed.toString() + " Km \nWind",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp),
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black, offset = Offset(1f, 1f), blurRadius = 1.5f
                    )
                )
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = weather.weather?.get(0)?.description.toString(),
                fontSize = 16.sp,
                color = Color.White,

                )

            Text(
                text = " " + weather.main?.temp.toString() + "°",
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black, offset = Offset(1f, 1f), blurRadius = 2.5f
                    )
                )
            )

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically


            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "Minimum Temperature",
                    modifier = Modifier
                        .size(14.dp)
                    ,
                )

                Text(
                    text = weather.main?.tempMin.toString() + "°",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black, offset = Offset(1f, 1f), blurRadius = 1.5f
                        )
                    )
                )
                Spacer(
                    modifier = Modifier
                        .width(16.dp)
                )

                Text(
                    text = weather.main?.tempMax.toString() + "°",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.Black, offset = Offset(1f, 1f), blurRadius = 1.5f
                        )
                    )
                )

                Image(
                    painter = painterResource(id = R.drawable.arrow_up),
                    contentDescription = "Maximum Temperature",
                    modifier = Modifier
                        .size(14.dp)
                    ,
                )
            }

        }


        Column(
            modifier = Modifier
//                        .padding(horizontal = 16.dp)
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(60.dp),
            )

            Text(
                text = weather.main?.humidity.toString() + "% \nHumidity",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp),
                style = TextStyle(
                    shadow = Shadow(
                        color = Color.Black, offset = Offset(1f, 1f), blurRadius = 1.5f
                    )
                )
            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SunnyPreview() {
    LilCloudTheme {
        WeatherScreen(Weather(null,null,null,null,null,null,null,null,null,null,null,null,null,null))
    }
}
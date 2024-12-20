package com.karan.lilcloud.composeUI

import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

//    if (viewModel.showLoading.value) {
//        Log.d("HowsTheWeather", "Loading Screen ....START...")
//        Loading()
//        Log.d("HowsTheWeather", "Loading Screen ....END...")
//
//    }

    val weather = viewModel.currentCondition.value
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

            weather?.let {
                WeatherDetail(viewModel, Modifier)
            } ?: if(viewModel.showLoading.value) Loading() else {/* TODO("Screen to show select city manually")*/}
        }
    }
}

@Composable
fun WeatherDetail(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {

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
        Loading()
//        WeatherScreen(WeatherViewModel())
    }
}
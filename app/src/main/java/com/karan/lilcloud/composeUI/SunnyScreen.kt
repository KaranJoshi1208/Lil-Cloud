package com.karan.lilcloud.composeUI

import android.util.Log
import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.karan.lilcloud.model.room.WeatherData
import com.karan.lilcloud.navigation.Screens
import com.karan.lilcloud.viewModel.WeatherViewModel
import kotlin.math.roundToInt


@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val data = viewModel.data.collectAsState().value
    val scrollState = rememberScrollState(0)
    val pageCount = remember(data.size) { PagerState { data.size } }
    val pagerState = rememberPagerState {                                  // watch out, potential bug 🚩
//        Log.d("HowsTheWeather", "PagerState value : ${data.size}")
        pageCount.pageCount
    }

    LaunchedEffect(viewModel.navIt.value) {
        if(viewModel.navIt.value) {
            navController.navigate(route = Screens.ManageLocations.name)
        }
    }


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
        var dragOffset = remember { mutableStateOf(0f) }
        val refreshThreshold = 150f
        var isRefreshing = false

        Column(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectVerticalDragGestures(
                        onVerticalDrag =  { _, dragAmount ->
                            if(dragAmount > 0) {
                                dragOffset.value += dragAmount
                            }

                        },

                        onDragStart = {
                            if(dragOffset.value > refreshThreshold && !isRefreshing) {
                                // TODO("Refresh the WeatherData")
                            }
                            // reset the drag counter
                            dragOffset.value = 0f
                        }
                    )
                }
            ,
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
                        .clickable(true) {
                            navController.navigate(route = Screens.ManageLocations.name)
                        }
                    ,
                )
            }

            // Implement Horizontal pager
            HorizontalPagerIndicator(
                pagerState = pagerState,
                pageCount = pageCount.pageCount,
                activeColor = Color.White,
                inactiveColor = Color.White.copy(alpha = 0.5f),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(12.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                HorizontalPager(
                    state = pagerState,
                    userScrollEnabled = true,

                    modifier = Modifier
                        .fillMaxWidth()
                ) { page ->
                    WeatherInfo(viewModel, data[page], scrollState)
                }
            }

//            viewModel.data.value?.let {
//                WeatherInfo(viewModel, scrollState)
//            }
//                ?: if (viewModel.showLoading.value) Loading() else {/* TODO("Screen to show select city manually")*/ }

        }
    }
}

@Composable
fun WeatherInfo(
    viewModel: WeatherViewModel,
    weather : WeatherData,
    scrollState: ScrollState,
//    modifier: Modifier = Modifier
) {

    val cc = weather.currentCondition
    val gl = weather.geoLocation

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 36.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Text(
            text = gl?.localizedName?.toString() ?: "where ?",
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


        Text(
            text = " " + cc?.temperature?.metric?.value?.roundToInt() + "°",
            fontSize = 100.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black, offset = Offset(1f, 1f), blurRadius = 2.5f
                )
            )
        )
        val temp = cc?.temperatureSummary?.past6HourRange

        Text(
            text = "${temp?.maximum?.metric?.value.toString()}° / ${temp?.minimum?.metric?.value.toString()}°",
            fontSize = 16.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
        )

        Text(
            text = cc?.weatherText.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Thin,
            color = Color.White,
        )

        WeatherDetails(viewModel, weather, Modifier.padding(top = 72.dp, start = 16.dp, end = 16.dp))
//        Wind(viewModel, Modifier.padding(horizontal = 16.dp, vertical = 20.dp))
        TemperatureGraph(viewModel, weather, modifier = Modifier.padding(bottom = 16.dp, top = 16.dp, end = 8.dp))
        QuinForecast(viewModel, weather, Modifier.padding(16.dp))
        Twilight(viewModel, weather, Modifier.padding(top = 16.dp, bottom = 40.dp, start = 16.dp, end = 16.dp))
    }
}

@Composable
fun WeatherDetails(viewModel: WeatherViewModel, weather : WeatherData, modifier: Modifier = Modifier) {
    val cc = weather.currentCondition ?: return

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
            ,
            colors = CardDefaults.cardColors(
                containerColor = Color(0x12000000),
                contentColor = Color.Unspecified,
                ),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = viewModel.whichWeatherIcon(cc.weatherIcon ?: 0)),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .size(128.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val temp = cc.temperatureSummary?.past6HourRange
                        Text(
                            text = temp?.maximum?.metric?.value.toString(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                        Text(
                            text = " / ",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = temp?.minimum?.metric?.value.toString(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    InfoElement(
                        name = "Humidity",
                        value = cc.relativeHumidity.toString() + " %"
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF)),
                    )

                    InfoElement(
                        name = "Real Feel",
                        value = cc.realFeelTemperature?.metric?.value.toString() + " °C"
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF)),
                    )

                    InfoElement(
                        name = "UV Index",
                        value = cc.uVIndex.toString() + " "
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF)),
                    )

                    InfoElement(
                        name = "Pressure",
                        value = cc.pressure?.metric?.value.toString() + " mbar"
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF)),
                    )

                    InfoElement(
                        name = "Chances of Rain",
                        value = "4" + " %"
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(0.5.dp)
                            .background(Color(0x33FFFFFF)),
                    )
                }
            }
        }
    }
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
fun InfoElement(name: String = "", value: String = "") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
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
package com.karan.lilcloud.composeUI

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karan.lilcloud.model.accuWeather.HalfDayForecastResponse
import com.karan.lilcloud.model.room.WeatherData
import com.karan.lilcloud.viewModel.WeatherViewModel

@Composable
fun TemperatureGraph(
    viewModel: WeatherViewModel,
    weather : WeatherData,
    modifier: Modifier = Modifier,
    lineColor: Color = Color.Green,
) {

    var temperatures : MutableList<HalfDayForecastResponse.HalfDayForecastResponseItem?> = mutableListOf()

    weather.halfDayForecast?.let {
        temperatures.addAll(it)
    } ?: return

    val (maxTemp, minTemp) = temperatures.fold(Double.MIN_VALUE to Double.MAX_VALUE) { acc, item ->
        val temp = item?.temperature?.value ?: 0.0
//        Pair<Double, Double>(maxOf(acc.first, temp) , minOf(acc.second, temp))   ...and here it is, MAGIC !!!
        maxOf(acc.first, temp) to minOf(acc.second, temp)

    }

    val reg = Regex("""T(\d{2})""")

    val scrollState = rememberScrollState()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color(0x12000000)
        )

    ) {

        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 12.dp)
                .horizontalScroll(scrollState)
        ) {
            temperatures.forEachIndexed { index, temp ->

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(80.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    // Render the temperature graph point
                    Text(
                        text = "${temp?.temperature?.value?.toInt()}°",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Thin
                    )

                    Box(
                        modifier = Modifier
                            .height(108.dp)
                            .padding(vertical = 20.dp)
                    ) {

                        Canvas(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            val graphHeight = size.height
                            val yScale = graphHeight / (maxTemp - minTemp)

                            // Calculate Y position for the temperature
                            val y = graphHeight - (((temp?.temperature?.value ?: 0.0) - minTemp) * yScale).toFloat()

                            // Draw the connecting line (if not the first point)
                            if (index > 0) {
                                val prevY =
                                    (graphHeight - (((temperatures[index - 1]?.temperature?.value ?: 0.0) - minTemp) * yScale)).toFloat()
                                drawLine(
                                    color = lineColor,
                                    strokeWidth = 1.dp.toPx(),
                                    start = androidx.compose.ui.geometry.Offset(
                                        -(size.width / 2),
                                        prevY
                                    ),
                                    end = androidx.compose.ui.geometry.Offset((size.width / 2), y)
                                )
                            }

                            // Draw hollow points
                            drawArc(
                                color = Color.White,
                                startAngle = 0f,
                                sweepAngle = 360f,
                                useCenter = false,
                                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.dp.toPx()),
                                topLeft = androidx.compose.ui.geometry.Offset(
                                    size.width / 2 - 4.dp.toPx(),
                                    y - 4.dp.toPx()
                                ),
                                size = _root_ide_package_.androidx.compose.ui.geometry.Size(
                                    width = 9.dp.toPx(),
                                    height = 9.dp.toPx()
                                ),

                                )
                        }
                    }

                    Image(
                        imageVector = ImageVector.vectorResource(id = viewModel.whichWeatherIcon(temp?.weatherIcon ?: 0)),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .size(24.dp),
                    )

                    Text(
                        text = viewModel.regex(temp?.dateTime ?: "", reg).let {
                            val time = it.toInt() + 1
                            if(time >= 12) {
                                "${(if(time%12 == 0) 12 else time%12 )} pm"
                            }else {
                                "$time am"
                            }
                        },
                        color = Color(0x50FFFFFF),
                        modifier = Modifier
                            .padding(top = 8.dp)
                    )
                }
            }
        }
    }
}
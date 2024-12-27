package com.karan.lilcloud.composeUI

import com.karan.lilcloud.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TemperatureGraph(
    temperatures: List<Float>, // List of temperature values
    hours: List<String>, // Corresponding hours
    modifier: Modifier = Modifier,
    lineColor: Color = Color.Black,
    pointColor: Color = MaterialTheme.colorScheme.secondary
) {
    val maxTemp = temperatures.maxOrNull() ?: 1f
    val minTemp = temperatures.minOrNull() ?: 0f

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 72.dp)
            .height(300.dp) // Increased height to accommodate temperature packets
    ) {
        items(temperatures.size) { index ->
            Column(
                modifier = Modifier.width(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Render the temperature graph point
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.7f) // Allocate 70% height for the graph
                        .padding(bottom = 8.dp)
                ) {
                    Canvas(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val graphHeight = size.height
                        val yScale = graphHeight / (maxTemp - minTemp)

                        // Calculate Y position for the temperature
                        val y = graphHeight - ((temperatures[index] - minTemp) * yScale)

                        // Draw the point
                        drawCircle(
                            color = pointColor,
                            radius = 4.dp.toPx(),
                            center = androidx.compose.ui.geometry.Offset(size.width / 2, y)
                        )

                        // Draw the connecting line (if not the first point)
                        if (index > 0) {
                            val prevY = graphHeight - ((temperatures[index - 1] - minTemp) * yScale)
                            drawLine(
                                color = lineColor,
                                strokeWidth = 2.dp.toPx(),
                                start = androidx.compose.ui.geometry.Offset(-size.width / 2, prevY),
                                end = androidx.compose.ui.geometry.Offset(size.width / 2, y)
                            )
                        }
                    }
                }

                // Render the temperature packet below the graph point
                TemperaturePacket()
            }
        }
    }
}



@Composable
fun TemperaturePacket() {
    Column (
        modifier = Modifier
            .height(200.dp)
            .width(50.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "34" + "°",
            fontSize = 16.sp,
            )

        Box() {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.cloudy_3_day),
                contentDescription = "Weather Icon",
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .size(50.dp)
                ,
            )
            Text(
                text = "1",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun TemperatureRange(
//    temperatures: List<Float>, // List of temperature values
//    hours: List<String>, // Corresponding hours
//    scrollState : ScrollState,
//    modifier: Modifier,
//    lineColor: Color,
//    pointColor: Color
) {
    LazyRow(
        modifier = Modifier
            .padding(top = 72.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
//            .horizontalScroll(scrollState)
    ){
        items(12) {i ->
            TemperaturePacket()
        }
    }
}

@Preview(showBackground = true, showSystemUi = false,)
@Composable
fun TemperatureScreen() {
    val temperatures = listOf(22f, 24f, 26f, 25f, 23f, 22f, 21f, 20f, 19f, 18f, 20f, 22f)
    val hours = List(12) { "${it + 1} AM" }

    val scrollState = rememberScrollState(0)

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
        TemperatureGraph(
            temperatures = temperatures,
            hours = hours,
//            scrollState = scrollState,
            modifier = Modifier.fillMaxWidth(),
            lineColor = Color.Green,
            pointColor = Color.Red
        )
//        TemperaturePacket()
//        TemperatureRange()
    }
}

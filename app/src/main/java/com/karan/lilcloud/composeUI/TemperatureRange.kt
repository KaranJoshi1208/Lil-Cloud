package com.karan.lilcloud.composeUI

import com.karan.lilcloud.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clipScrollableContainer
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun TemperatureGraph(
    temperatures: List<Float>,
    hours: List<String>,
    modifier: Modifier = Modifier,
    lineColor: Color = Color.Black,
    pointColor: Color = MaterialTheme.colorScheme.secondary
) {
    val maxTemp = temperatures.maxOrNull() ?: 1f
    val minTemp = temperatures.minOrNull() ?: 0f


    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 72.dp)
            .height(300.dp)
            .horizontalScroll(scrollState)
    ) {
        temperatures.forEachIndexed { index, temp ->

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(80.dp)
//                    .padding(start = 16.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // Render the temperature graph point
                Text(
                    text = "${temp.toInt()}°",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Thin
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.7f)
                        .padding(top = 32.dp, bottom = 16.dp)
                ) {

                    Canvas(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val graphHeight = size.height
                        val yScale = graphHeight / (maxTemp - minTemp)

                        // Calculate Y position for the temperature
                        val y = graphHeight - ((temp - minTemp) * yScale)

                        // Draw the point


                        // Draw the connecting line (if not the first point)
                        if (index > 0) {
                            val prevY = graphHeight - ((temperatures[index - 1] - minTemp) * yScale)
                            drawLine(
                                color = lineColor,
                                strokeWidth = 1.dp.toPx(),
                                start = androidx.compose.ui.geometry.Offset(-(size.width / 2), prevY),
                                end = androidx.compose.ui.geometry.Offset((size.width / 2), y)
                            )
                        }

                        drawArc(
                            color = Color.White,
                            startAngle = 0f,
                            sweepAngle = 360f,
                            useCenter = false,
                            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.dp.toPx()),
                            topLeft = androidx.compose.ui.geometry.Offset(size.width / 2 - 4.dp.toPx(), y - 4.dp.toPx()),
                            size = _root_ide_package_.androidx.compose.ui.geometry.Size(
                                width = 9.dp.toPx(),
                                height = 9.dp.toPx()
                            ),

                        )
                    }
                }

                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.cloudy_3_day),
                    contentDescription = "Weather Icon",
                    modifier = Modifier
                        .size(60.dp)
                    ,
                )

                Text(
                    text = hours.getOrNull(index) ?: "${index + 1}:00",
                    color = Color(0x50FFFFFF),
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false,)
@Composable
fun TemperatureScreen() {
    val temperatures = listOf(22f, 24f, 26f, 25f, 23f, 22f, 21f, 20f, 19f, 18f, 20f, 22f)
    val hours = List(12) { "${it + 1} AM" }

//    val scrollState = rememberScrollState(0)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF152FB2),
                        Color(0xFF03A9F4)
                    )
                )
            )
    ) {
        TemperatureGraph(
            temperatures = temperatures,
            hours = hours,
            modifier = Modifier.fillMaxWidth(),
            lineColor = Color.Green,
            pointColor = Color.Red
        )
    }
}

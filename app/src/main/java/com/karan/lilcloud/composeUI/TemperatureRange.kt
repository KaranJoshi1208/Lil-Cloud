package com.karan.lilcloud.composeUI

import com.karan.lilcloud.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karan.lilcloud.model.accuWeather.CurrentConditionResponse
import kotlin.math.roundToInt

@Composable
fun TemperatureGraph(
    temperatures: List<Float>, // List of temperature values
    hours: List<String>, // Corresponding hours
    scrollState : ScrollState,
    modifier: Modifier = Modifier,
    lineColor: Color = Color.Black,
    pointColor: Color = MaterialTheme.colorScheme.secondary
) {
    val maxTemp = temperatures.maxOrNull() ?: 1f
    val minTemp = temperatures.minOrNull() ?: 0f

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 72.dp)
            .height(200.dp)
            .horizontalScroll(enabled = true, state = scrollState)

    ) {


        Canvas(
            modifier = modifier
                .width((temperatures.size * 50).dp)
                .height(200.dp)
                .padding(16.dp)
        ) {
            val graphWidth = size.width
            val graphHeight = size.height

            // Calculate scale for temperature values
            val yScale = graphHeight / (maxTemp - minTemp)
            val xSpacing = graphWidth / (temperatures.size - 1)

            // Path for the line graph
            val path = Path().apply {
                temperatures.forEachIndexed { index, temp ->
                    val x = index * xSpacing
                    val y = graphHeight - ((temp - minTemp) * yScale)
                    if (index == 0) moveTo(x, y) else lineTo(x, y)
                }
            }


            // Draw the graph line
            drawPath(
                path = path,
                color = lineColor,
                style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round, join = StrokeJoin.Round)
            )

            // Draw points on the graph
            temperatures.forEachIndexed { index, temp ->
                val x = index * xSpacing
                val y = graphHeight - ((temp - minTemp) * yScale)
                drawCircle(
                    color = pointColor,
                    radius = 4.dp.toPx(),
                    center = androidx.compose.ui.geometry.Offset(x, y)
                )
            }
        }
    }
}


@Composable
fun TemperaturePacket() {
    Column (
        modifier = Modifier
            .padding(top = 144.dp, start = 20.dp)
            .height(175.dp)
            .width(50.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "34" + "°C",
        )

        Image(
            painter = rememberVectorPainter(ImageVector.vectorResource(id = R.drawable.cloudy_3_day)),
//            painter = painterResource(id = R.drawable.cloudy),
            contentDescription = "Weather Icon"
        )
    }

}

@Preview(showBackground = true, showSystemUi = true,)
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
//        TemperatureGraph(
//            temperatures = temperatures,
//            hours = hours,
//            scrollState = scrollState,
//            modifier = Modifier.fillMaxWidth(),
//            lineColor = Color.Green,
//            pointColor = Color.Red
//        )

        TemperaturePacket()
    }
}

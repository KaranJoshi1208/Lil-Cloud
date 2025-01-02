package com.karan.lilcloud.composeUI

import android.widget.ProgressBar
import com.karan.lilcloud.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Twilight() {

    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 144.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
            ,
            colors = CardDefaults.cardColors(
                containerColor = Color(0x12FFFFFF)
            )
            
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                ,
//                contentAlignment = Alignment.Center

            ) {
                var offset : Offset? = null
                var c : Size? = null

                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    offset = Offset((size.width/6.5f), 50.dp.toPx())
                    val x = (size.width/6.5f)
                    c = Size(125.dp.toPx()+x, 175.dp.toPx())

                    drawArc(
                        color = Color.White.copy(alpha = 0.2f),
                        startAngle = 0f,
                        sweepAngle = -180f,
                        useCenter = false,
                        topLeft = offset,
                        size = Size(250.dp.toPx(), 250.dp.toPx()),
                        style = Stroke(width = 1.dp.toPx()),
                    )

                }

                Box(
                    modifier = Modifier
                        .wrapContentSize()
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.clear_day ),
                        contentDescription = "Sun",
                        modifier = Modifier
                            .size(60.dp)
                            .offset(c?.width?.dp ?: 0.dp,c?.height?.dp ?: 0.dp)
                        ,
                    )
                }
            }
        }
    }
}

@Composable
fun Twilight2() {
    // Current angle of the sun
    val sunAngle = remember { mutableFloatStateOf(0f) } // Start at 0 degrees (horizon)

    // Animate the angle (you can customize this logic for real-time animation)
    LaunchedEffect(Unit) {
        while (true) {
            sunAngle.value = (sunAngle.value + 1f) % 180f // Animate from 0° to 180°
            delay(50L) // Adjust for animation speed
        }
    }

    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 144.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0x12FFFFFF)
            )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ){
                CircularProgressIndicator(
                    progress = { .3f },
                    color = Color.Green,
                    trackColor = Color.Transparent,

                    modifier = Modifier
                        .size(250.dp)
                        .rotate(-90f)
                )

                CircularProgressIndicator(
                    progress = { .5f },
                    color = Color.White.copy(alpha = .2f),
                    trackColor = Color.Transparent,
                    strokeWidth = 1.dp,
                    modifier = Modifier
                        .size(250.dp)
                        .rotate(-90f)
                )

                Box(
                    modifier = Modifier
                        .wrapContentSize()
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.clear_day ),
                        contentDescription = "Sun",
                        modifier = Modifier
                            .size(60.dp)
                        ,
                    )
                }

            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TwilightPreview() {
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
//        SunriseSunsetPath()
        Twilight2()
    }
}
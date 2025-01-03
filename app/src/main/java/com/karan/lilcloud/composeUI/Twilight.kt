package com.karan.lilcloud.composeUI

import com.karan.lilcloud.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Twilight(
    progress : Int = 10,
) {

    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 144.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            ,
            colors = CardDefaults.cardColors(
                containerColor = Color(0x12FFFFFF)
            )

        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                ,

            ) {
                var offset : Offset? = null

                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    offset = Offset(55.dp.toPx(), 25.dp.toPx())
                    var start = -180f
                    var arcColor = Color.Yellow

                    for(i in 0 until 19) {
                        if(i != progress ) {
                            drawArc(
                                color = arcColor,
                                startAngle = start,
                                sweepAngle = 5f,
                                useCenter = false,
                                topLeft = offset,
                                size = Size(250.dp.toPx(), 250.dp.toPx()),
                                style = Stroke(width = 1.dp.toPx()),
                            )
                        } else {
                            arcColor = Color.White.copy(alpha = 0.2f)
                        }
                        start += 10f
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val radian = ((180f - progress*10) - 2.5) * PI/180.0f
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.clear_day ),
                        contentDescription = "Sun",
                        modifier = Modifier
                            .size(50.dp)
                            .offset((155 + 125 * cos(radian)).dp, (125 - 125 * sin(radian)).dp)
                        ,
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.25f)
                            .align(Alignment.BottomCenter)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(0.5.dp)
                                .background(Color.White.copy(alpha = 0.2f))
                        )

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 4.dp)
                        ) {
                            Text(text = "5:30", color = Color.White.copy(alpha = 0.4f))
                            Text(text = "6:20", color = Color.White.copy(alpha = 0.4f))
                        }

                    }
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
                        Color(0xFF03A9F4)
                    )
                )
            )
    ) {
//        SunriseSunsetPath()
        Twilight(12)
    }
}
package com.karan.lilcloud.composeUI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.karan.lilcloud.viewModel.WeatherViewModel

@Composable
fun Wind(viewmodel : WeatherViewModel, modifier: Modifier) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        val wind = viewmodel.data.collectAsState().value[0].currentCondition?.wind
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            colors = CardDefaults.cardColors(
                containerColor = Color(0x12000000),
            ),

            ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(start = 16.dp, bottom = 12.dp)
                    ,
                    verticalArrangement = Arrangement.Center

                ) {

                    InfoElement(
                        name = "Speed",
                        value =  wind?.speed?.metric?.value.toString() + " Km/h"
                    )
                    InfoElement(
                        name = "Direction",
                        value = wind?.direction?.english.toString()
                    )

                    InfoElement(
                        name = "Degrees",
                        value = wind?.direction?.degrees.toString() + "°"
                    )

                    InfoElement(
                        name = "Gust Speed",
//                        value =  viewmodel.currentCondition.value?.windGust?.speed?.metric?.value.toString() + " Km/h"
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(132.dp)
                            .clip(shape = CircleShape)
                            .border(width = 1.dp, color = Color.Red, shape = CircleShape)

                    ) {
                        // Compass directions
                        Text(
                            text = "N",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(top = 4.dp),
                            color = Color(0xFF8B0000)
                        )
                        Text(
                            text = "E",
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(end = 10.dp),
                            color = Color.White
                        )
                        Text(
                            text = "S",
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 4.dp),
                            color = Color.Blue
                        )
                        Text(
                            text = "W",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .padding(start = 8.dp),
                            color = Color.White
                        )

                        // Needle (arrow)

                        Box(
                            modifier = Modifier
                                .padding(30.dp)
                                .fillMaxSize()
                                .rotate((wind?.direction?.degrees)?.toFloat() ?: 0f)
                            ,
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxHeight(0.7f)
                                    .width(2.dp)
                                    .background(Color(0xFFFFD700))
                                ,
                            )
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(Color.Black)
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}
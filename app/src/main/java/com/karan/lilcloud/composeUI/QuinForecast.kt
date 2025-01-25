package com.karan.lilcloud.composeUI

import android.graphics.Paint.Align
import android.text.Layout
import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karan.lilcloud.model.accuWeather.QuinForecastResponse
import com.karan.lilcloud.ui.theme.LilCloudTheme

@Composable
fun QuinForecast(
    modifier : Modifier,
) {

    val data = mutableListOf(1,2,3,4,5)

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0x12000000)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .then(modifier)
//            .height(300.dp)

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "5 Days Forecast",
                fontWeight = FontWeight.SemiBold,
                color = Color(0x40FFFFFF),
//                modifier = Modifier
//                    .padding(bottom = 12.dp)
            )

            data.forEachIndexed { index, item ->

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.tstorm),
                        contentDescription = "Weather Icon",
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Text(
                        text = "Sunday",
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0x80FFFFFF),
                        modifier = Modifier
//                            .weight(1f)
                            .padding(horizontal = 16.dp)
                    )

                    Text(
                        text = "Mostly Cloudy it is today but tomorrow , who knows?",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color(0x80FFFFFF),
                        modifier = Modifier
                            .width(100.dp)
//                            .weight(1f)
                    )

                    Text(
                        text = "20°/12°",
                        textAlign = TextAlign.End,
                        fontSize = 12.sp,
                        color = Color(0x80FFFFFF),
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .weight(1f)
                    )
                }

            }

        }

    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuinPreview() {
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
        QuinForecast(Modifier.padding(top = 144.dp))
    }
}
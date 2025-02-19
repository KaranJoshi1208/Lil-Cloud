package com.karan.lilcloud.composeUI

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.karan.lilcloud.R
import com.karan.lilcloud.navigation.Screens
import com.karan.lilcloud.viewModel.WeatherViewModel

@Composable
fun NavBar( viewModel: WeatherViewModel,
            pagerState : PagerState,
            pageCount : PagerState,
            navController: NavController,
            modifier: Modifier = Modifier) {

    val data = viewModel.data.collectAsState().value
    Box(
        modifier = Modifier
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
            .fillMaxWidth()
            .height(64.dp)
            .then(modifier)
        ,
    ) {

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.menu),
            contentDescription = "Menu",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(32.dp)
                .align(Alignment.CenterStart)
                .clickable(true) {
                    navController.navigate(route = Screens.ManageLocations.name)
                }

            ,
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)

        ) {
//            Text(
//                text = data[pagerState.pageCount-1].geoLocation?.localizedName.toString(),
//                fontSize = 24.sp,
//                color = Color(0xFFFFFFFF),
//                modifier = Modifier
//            )

            if(viewModel.showLoading.value) {
                val infiniteTransition = rememberInfiniteTransition(label = "")
                val alpha = infiniteTransition.animateFloat(
                    initialValue = 0.3f,
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(durationMillis = 1000, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ), label = ""
                )
                Text(
                    text = "☁\uFE0F Updating...",
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .alpha(alpha.value)
                )
            }else {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    pageCount = pageCount.pageCount,
                    activeColor = Color.White,
                    inactiveColor = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavPreview() {
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
//        NavBar(Modifier)
    }
}
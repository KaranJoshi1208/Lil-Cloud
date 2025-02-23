package com.karan.lilcloud.composeUI

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karan.lilcloud.viewModel.WeatherViewModel


@Composable
fun ManageLocations(viewModel: WeatherViewModel) {
    var isExpended = remember { mutableStateOf(false) }
//    var scrollState = rememberScrollState(0)

    if (viewModel.showDialog.value) {
        EnableLocationDialog(
            { viewModel.showLocationSettings() },
            { viewModel.showDialog.value = false }
        )
    }

    // Parent column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = WindowInsets.statusBars
                    .asPaddingValues()
                    .calculateTopPadding()
            )
//            .verticalScroll(scrollState)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.arrow_back),
                contentDescription = "Previous Screen",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(28.dp)

            )

            Text(
                text = "Manage Locations",
                fontWeight = FontWeight.W300,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        SearchBar(viewModel, isExpended, Modifier.padding(horizontal = 12.dp))
        TopCities(viewModel, isExpended)
        Locations(viewModel)

    }

}

@Composable
fun SearchBar(
    viewModel: WeatherViewModel,
    isExpended: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {
    val query = remember { mutableStateOf("") }
    val isFocused = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    TextField(
        value = query.value,
        onValueChange = {
            query.value = it
            if (query.value.length > 3 && viewModel.isSearching) {
                viewModel.searchLocation(query.value)
            }
        },
        shape = RoundedCornerShape(32.dp),
        leadingIcon = {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.loctn_srch),
                contentDescription = "Search ?",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .alpha(0.5f)
            )
        },
        trailingIcon = {
            if (isFocused.value) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.close),
                    contentDescription = "Search ?",
                    modifier = Modifier
                        .padding(end = 12.dp)
                        .clickable(enabled = true) {
                            focusManager.clearFocus()
                            isExpended.value = false
                        }
                )
            }
        },
        placeholder = {
            Text(
                text = "Which City ?",
                fontSize = 14.sp,
                modifier = Modifier
                    .alpha(0.5f)
                    .padding(start = 8.dp)
            )
        },
        textStyle = TextStyle(fontSize = 16.sp),
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Blue
        ),

        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .size(52.dp)
            .onFocusChanged {
                isExpended.value =
                    true                     // might shift this line to clickable{} 🚩
                isFocused.value = it.isFocused
            }
    )
    if (isFocused.value) SearchItems(viewModel)

}

@Composable
fun TopCities(viewModel: WeatherViewModel, isExpended: MutableState<Boolean>, modifier: Modifier = Modifier) {

    Card(
//        shape = CardDefaults.elevatedShape,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            )
//            .clickable(true) {
//                isExpended.value = !isExpended.value
//            }
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(32.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0x12000000))
                        .clickable(true) {
                            viewModel.triggerRequestingPermission()
                        }
//                        .weight(1f)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.my_location),
                        contentDescription = "Locate Me",
                        modifier = Modifier
                            .padding(start = 8.dp, end = 4.dp)
                            .size(18.dp)
                    )
                    Text(
                        text = "Locate Me",
                        fontWeight = FontWeight.W200,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(32.dp)
                        .clip(shape = RoundedCornerShape(16.dp))
                        .background(color = Color(0x12000000))
//                        .weight(1f)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.globe_location_pin),
                        contentDescription = "Coordinates",
                        modifier = Modifier
                            .padding(start = 8.dp, end = 4.dp)
                            .size(16.dp)

                    )
                    Text(
                        text = "Coordinates",
                        fontWeight = FontWeight.W200,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()
            ) {
                City("Almora")
                City("Dwarahat")
                City("Nanital")
                City("Ohio")
                City("Tokyo")

            }

            if (false) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                ) {
                    City("Haldwani")
                    City("Delhi")
                    City("Rishikesh")
                    City("Haridwar")
                    City("Dwarka")
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                ) {
                    City("Delhi")
                    City("Noida")
                    City("Dwarka")
                    City("Niger")
                    City("Chile")
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                ) {
                    City("Nanital")
                    City("Noida")
                    City("Dwarahat")
                    City("Niger")
                    City("Chile")
                }
            }
        }
    }
}

@Composable
fun City(city: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color(0x12000000))
            .then(modifier)
    ) {
        Text(
            text = city,
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.W200,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun SearchItems(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {

    val result = viewModel.searchResponse

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(result.size) { index ->
            val temp = result[index]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                ) {
                    Text(
                        text = temp?.localizedName.toString(),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W300,
                        modifier = Modifier

                    )
                    Text(
                        text = "${temp?.administrativeArea?.localizedName}, ${temp?.country?.localizedName}",
                        fontSize = 12.sp,
                        color = Color.Black.copy(0.5f),
                        modifier = Modifier
                    )
                }

                val isDone = remember { mutableStateOf(false) } // need to check if this location is already added or not
                Image(
                    imageVector = ImageVector.vectorResource(id = if (!isDone.value) R.drawable.add else R.drawable.check),
                    contentDescription = "Add?",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(32.dp)
                        .clickable(true) {
                            viewModel.addLocation(temp?.key)
                        }
                )
            }
        }
    }

}

//@Preview(showBackground = true)
@Composable
fun Locations(viewModel: WeatherViewModel, modifier: Modifier = Modifier) {
    val data = viewModel.data.collectAsState().value
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(data.size) { index ->
            val temp = data[index]
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color(0x12000000))

            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = temp.geoLocation?.localizedName.toString(),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        modifier = Modifier

                    )
                    Text(
                        text = "${temp.currentCondition?.temperatureSummary?.past6HourRange?.maximum?.metric?.value}°/${temp.currentCondition?.temperatureSummary?.past6HourRange?.minimum?.metric?.value}°",
                        fontSize = 12.sp,
                        color = Color.Black.copy(0.5f),
                        modifier = Modifier
                    )
                }

                Image(
                    painter = painterResource(
                        id = viewModel.whichWeatherIcon(
                            temp.currentCondition?.weatherIcon ?: 0
                        )
                    ),
                    contentDescription = "Add?",
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 16.dp)
                        .size(32.dp)
                )

            }
        }
    }
}

@Composable
fun EnableLocationDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(text = "Location Services")
        },
        text = {
            Text(text = "Location services are required to show weather, please enable them.")
        },
        confirmButton = {
            Text(
                text = "Go to Settings",
                color = Color.Blue,
                modifier = Modifier
                    .clickable(enabled = true, onClick = { onConfirm() })
            )
        },
        dismissButton = {
            Text(
                text = "Cancel",
                color = Color.Blue,
                modifier = Modifier
                    .clickable(enabled = true, onClick = { onDismiss() })
                    .padding(end = 36.dp)
            )
        },
    )
}


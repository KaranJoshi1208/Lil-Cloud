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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.NavController
import com.karan.lilcloud.viewModel.WeatherViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun ManageLocations(
    viewModel: WeatherViewModel,
    navController: NavController,
    needPermission: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )

    if (viewModel.showDialog.value) {
        EnableLocationDialog(
            { viewModel.showLocationSettings() },
            { viewModel.showDialog.value = false }
        )
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            BottomDialog(viewModel, scope, sheetState)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = WindowInsets.statusBars
                        .asPaddingValues()
                        .calculateTopPadding()
                )
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
                        .clickable(true) {
                            navController.popBackStack()
                        }
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

            SearchBar(viewModel, Modifier.padding(horizontal = 12.dp))
            TopCities(viewModel, navController, sheetState, scope, needPermission)
            Locations(viewModel)
        }
    }
}


@Composable
fun SearchBar(
    viewModel: WeatherViewModel,
    modifier: Modifier = Modifier
) {
    val query = remember { mutableStateOf("") }
    val isFocused = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    TextField(
        value = query.value,
        onValueChange = {
            query.value = it
            if (query.value.length > 3) {
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
                isFocused.value = it.isFocused
            }
    )
    if (isFocused.value) SearchItems(viewModel)

}

@Composable
fun TopCities(
    viewModel: WeatherViewModel,
    navController: NavController,
    sheetState: ModalBottomSheetState,
    scope: CoroutineScope,
    needPermission: () -> Unit,
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            )

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
                            needPermission()
                            navController.popBackStack()
                        }
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
                        .clickable(true) {
                            scope.launch {
                                sheetState.show()
                            }
                        }
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
                City("Almora") {
                    viewModel.addLocation("191359")
                }
                City("Dwarahat") {
                    viewModel.addLocation("196541")
                }
                City("Nainital ") {
                    viewModel.addLocation("191346")
                }
                City("Ohio") {
                    viewModel.addLocation("3388995")
                }
                City("Tokyo") {
                    viewModel.addLocation("226396")
                }
            }
        }
    }
}

@Composable
fun City(city: String, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color(0x12000000))
            .clickable(true) {
                onClick()
            }
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
fun SearchItems(viewModel: WeatherViewModel) {

    val result = viewModel.searchResponse

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(result.size/2) { index ->
            val temp = result[index]
            val isDone = remember {
                mutableStateOf(viewModel.isAdded(temp?.key.toString()))
            }

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

@Composable
private fun BottomDialog(
    viewModel: WeatherViewModel,
    scope: CoroutineScope,
    sheetState: ModalBottomSheetState
) {
    var lat = remember { mutableStateOf("") }
    var lon = remember { mutableStateOf("") }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .imePadding()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {


            OutlinedTextField(
                value = lat.value,
                onValueChange = { lat.value = it },
                label = {
                    Text(
                        text = "Latitude",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )
                },
                placeholder = {
                    Text(
                        text = "eg: -8.340539",
                        color = Color(0x33000000),
                        fontSize = 16.sp,
                    )
                },
                textStyle = TextStyle(fontSize = 18.sp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = lon.value,
                onValueChange = { lon.value = it },
                label = {
                    Text(
                        text = "Longitude",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1f)
                    )
                },
                placeholder = {
                    Text(
                        text = "eg: 115.091949",
                        color = Color(0x33000000),
                        fontSize = 16.sp,
                    )
                },
                textStyle = TextStyle(fontSize = 18.sp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    viewModel.addCoordinateLocation(lat.value, lon.value)
                    scope.launch {
                        sheetState.hide()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
            ) {
                Text("Find")
            }

            Spacer(modifier = Modifier.windowInsetsBottomHeight(WindowInsets.ime))
        }
    }
}

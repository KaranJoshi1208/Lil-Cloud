package com.karan.lilcloud.composeUI

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.karan.lilcloud.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ManageLocations() {

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
                    .size(32.dp)

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

//        SearchBar(Modifier.padding(horizontal = 12.dp))
        TopCities()


    }

}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    val query = remember { mutableStateOf("") }
    val isFocused = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    TextField(
        value = query.value,
        onValueChange = {query.value = it},

        shape = RoundedCornerShape(32.dp),
        leadingIcon = {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.loctn_srch),
                contentDescription = "Search ?",
                modifier = Modifier
                    .padding(start = 12.dp)
                    .alpha(0.7f)
            )
        },
        trailingIcon = {
            if(isFocused.value) {
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
                modifier = Modifier
                    .alpha(0.5f)
                    .padding(start = 8.dp)
            )
        },
        textStyle = TextStyle(fontSize = 20.sp),
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
            .onFocusChanged {
                isFocused.value = it.isFocused
            }
    )

}

@Composable
fun TopCities(modifier: Modifier = Modifier) {

    Card(
        
    ) {

    }
    
}
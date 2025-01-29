package com.karan.lilcloud.composeUI

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ManageLocations() {
    Text(
        text = "Manage ALL Locations , HERE !!!",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(top = 144.dp)
            .fillMaxSize()
    )
}
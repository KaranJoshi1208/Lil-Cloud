package com.karan.lilcloud.navigation

sealed class Screens(val name : String) {
    object Home : Screens(name = "home")
    object ManageLocations : Screens(name = "manage_locations")
}
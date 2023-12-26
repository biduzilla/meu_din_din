package com.ricky.meudindin.navigation

sealed class Screens(val route:String){
    object SpashScreen:Screens(
        route = "splash_screen"
    )

    object MainScreen:Screens(
        route = "main_screen"
    )
}

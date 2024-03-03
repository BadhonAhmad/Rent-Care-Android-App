package com.example.rentcare

sealed class Screen(val route : String){
    object Welcome : Screen(route = "Welcome_screen")
    object Login : Screen(route = "Login_screen")
    object SignUpScreen : Screen(route = "Signup_screen")
    object Profile : Screen(route = "profile")
    object HomePage : Screen(route = "homepage")
    object Notifications : Screen(route = "notifications")
    object YourUnit: Screen(route = "yourunit")
    object EnterUnit: Screen(route = "enterunit")
    object SignUpAs : Screen(route = "signupas")
    object FindAUnit : Screen(route = "findaunit")
    object RentersUnitDetails:Screen(route = "rentersunitdetails")
    object CreateFlat: Screen(route = "createflat")
    object SignUpOwner: Screen(route = "signupowner")

}

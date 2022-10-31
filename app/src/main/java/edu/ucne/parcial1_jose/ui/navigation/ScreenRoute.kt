package edu.ucne.parcial1_jose.ui.navigation

sealed class ScreenRoute (val route: String){
    object ArticuloList: ScreenRoute("ArticuloList")
    object  ArticuloForm: ScreenRoute("ArticuloForm")
}
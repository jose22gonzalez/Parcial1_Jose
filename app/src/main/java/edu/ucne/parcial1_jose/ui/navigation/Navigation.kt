package edu.ucne.parcial1_jose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList.ArticuloListScreen
import edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaScreen.PantallaScreen


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "PantallaListScreen"){
        composable("PantallaListScreen"){
            ArticuloListScreen(onClick = {navController.navigate("PantallaScreen")})
        }

        composable("PantallaScreen"){
            PantallaScreen({navController.navigateUp()})
        }
    }
}


package edu.ucne.parcial1_jose.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList.PantallalistScreen
import edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaScreen.PantallaScreen


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "PantallaListScreen"){
        composable("PantallaListScreen"){
            PantallalistScreen(onClick = {navController.navigate("PantallaScreen")})
        }

        composable("PantallaScreen"){
            PantallaScreen({navController.navigateUp()})
        }
    }
}


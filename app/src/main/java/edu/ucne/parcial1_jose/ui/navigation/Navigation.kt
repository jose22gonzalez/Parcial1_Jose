package edu.ucne.parcial1_jose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList.ArticuloListScreen
import edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaScreen.PantallaScreen


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = ScreenRoute.ArticuloList.route){

        composable(ScreenRoute.ArticuloList.route){
            ArticuloListScreen(onNavigateToArticulo = { articuloId ->
                navController.navigate(ScreenRoute.ArticuloForm.route +
                        "/$articuloId"
                )
            })
        }

        composable(
            ScreenRoute.ArticuloForm.route + "/{articuloId}",
            arguments = listOf(navArgument("articuloId"){type = NavType.IntType}),
        ){backStackEntry ->

            val articuloId = backStackEntry.arguments?.getInt("articuloId") ?: 0
            PantallaScreen(articuloId,
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}
/*onClick = {navController.navigate("PantallaScreen")}
{navController.navigateUp()}*/

/*composable(ScreenRoute.ArticuloList.route){
    ArticuloListScreen(onNavigateToArticulo = {navController.navigate(ScreenRoute.ArticuloForm.route )})
}

composable(ScreenRoute.ArticuloForm.route
){
    PantallaScreen(onNavigateBack = {navController.navigateUp()})*/
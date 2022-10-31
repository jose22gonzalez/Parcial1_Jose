package edu.ucne.parcial1_jose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial1_jose.ui.navigation.Navigation
import edu.ucne.parcial1_jose.ui.theme.Parcial1_JoseTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_JoseTheme {
                var navcontroller = rememberNavController()
                Navigation(navcontroller)
            }
        }
    }
}


package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.TextField
import androidx.compose.material3.CenterAlignedTopAppBar


@Composable
fun PantallaScreen(
    onNavigateBack: () -> Unit,
) {

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Examen Entry")})
        },
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {


            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                onClick = {
                    onNavigateBack()
                }) {
                Text(text = "Add a Examen")
            }

        }
    }
}
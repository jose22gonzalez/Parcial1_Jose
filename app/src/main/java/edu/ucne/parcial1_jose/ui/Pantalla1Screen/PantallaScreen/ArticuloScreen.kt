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



@Composable
fun PantallaScreen(
    onNavigateBack: () -> Unit,
    viewModel: ArticuloScreenViewModel = hiltViewModel()
) {

    Scaffold (
        topBar = { Text(
            text = "Registro Articulos",
            style = MaterialTheme.typography.h5
        )},
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = viewModel.Descripcion,
                label = { Text(text = "Descripcion")},
                onValueChange = {viewModel.Descripcion = it}
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = viewModel.Marca,
                label = { Text(text = "Marca")},
                onValueChange = {viewModel.Marca = it}
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = viewModel.Existencia,
                label = { Text(text = "Existencia")},
                onValueChange = {viewModel.Existencia = it}
            )


            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                onClick = {
                    onNavigateBack()
                    viewModel.save()
                }) {
                Text(text = "Add a Articulo")
            }

        }
    }
}
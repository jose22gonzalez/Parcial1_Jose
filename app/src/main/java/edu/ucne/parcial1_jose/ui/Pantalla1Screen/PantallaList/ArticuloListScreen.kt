package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.parcial1_jose.data.Remote.dto.ArticuloResponseDTO


@Composable
fun ArticuloListScreen(
    onNavigateToArticulo: (Int) -> Unit,
    viewModel: ArticuloListViewModel = hiltViewModel()
) {
    Scaffold (
        topBar = { Text(
            text = "Consulta Articulos",
            style = MaterialTheme.typography.h5
        )},
        floatingActionButton = {
            FloatingActionButton(onClick = {onNavigateToArticulo(0)}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a Examen")
            }
        },

        ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {
            ArticuloList(
                articulo = uiState.articulo,
            ){articuloId ->
                onNavigateToArticulo(articuloId)
            }

        }
    }


}

/*
modifier = Modifier
.fillMaxSize()
.padding(it),
*/

@Composable
fun ArticuloList(
    articulo: List<ArticuloResponseDTO>,
    viewModel: ArticuloListViewModel = hiltViewModel(),
    onNavigateToArticulo: (Int) -> Unit
    ) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(articulo) { articul ->
            ArticuloRow(articul, viewModel){articuloId ->
                onNavigateToArticulo(articuloId)
            }
        }
    }
}

@Composable
fun ArticuloRow(articulo: ArticuloResponseDTO, viewModel: ArticuloListViewModel, onNavigateToArticulo: (Int) -> Unit) {
    Card(
        elevation = 16.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    onNavigateToArticulo(
                        articulo.ariticuloId?:0
                    )
                    Log.i("parametro", articulo.toString())
                }
            )
    ) {

        Row(modifier = Modifier.padding(10.dp)) {
            Column(
                modifier = Modifier
                    .padding(5.dp)

            ) {

                Text(
                    text = "Descripcion: ${articulo.ariticuloId}",
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Descripcion: ${articulo.descripcion}",
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = "Marca: ${articulo.marca}",
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = "Precio: ${articulo.precio}",
                    style = MaterialTheme.typography.h6
                )


                Text(
                    text = "EXistencias: ${articulo.existencia}",
                    style = MaterialTheme.typography.h6
                )

                Row(modifier = Modifier.padding(5.dp)) {
                    IconButton(
                        modifier = Modifier.padding(0.dp),
                        onClick = { viewModel.Delete(articulo.ariticuloId)}) {
                        Icon(imageVector = Icons.Outlined.Clear, contentDescription = "Eliminar",
                            tint = Color.Red)}

                    IconButton(
                        modifier = Modifier.padding(5.dp),
                        onClick = {}) {
                        Icon(imageVector = Icons.Outlined.Edit, contentDescription = "Editar",
                            tint = Color.Blue)}
                }


            }


        }

    }
}

//Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(4.dp)
//    ) {
//
//        Text(
//            text = "Descripcion ${articulo.Descripcion}",
//            style = MaterialTheme.typography.subtitle1
//        )
//
//        Text(
//            text = "Marca ${articulo.Marca}",
//            style = MaterialTheme.typography.subtitle1
//        )
//
//        Text(
//            text = "Existencia ${articulo.Existencia}",
//            style = MaterialTheme.typography.subtitle1
//        )
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//
//
//            IconButton(
//                modifier = Modifier.padding(0.dp),
//                onClick = {viewModel.Delete(articulo) }) {
//                Icon(imageVector = Icons.Outlined.Clear, contentDescription = "Eliminar",
//                    tint = Color.Red)
//            }
//        }
//
//        Divider(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 4.dp),
//            color = Color.LightGray
//        )
//    }


























//isDigitOnly
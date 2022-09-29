package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.IconButton
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.parcial1_jose.data.entity.Articuloentity


@Composable
fun ArticuloListScreen(
    onClick: () ->Unit,
    viewModel: ArticuloListViewModel = hiltViewModel()
) {
    Scaffold (
        topBar = { Text(
            text = "Consulta Articulos",
            style = MaterialTheme.typography.h5
        )},
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            )

        }
    }


}

@Composable
fun ArticuloList(
    articulo: List<Articuloentity>,
    modifier: Modifier = Modifier,
    viewModel: ArticuloListViewModel = hiltViewModel(),

    ) {
    LazyColumn(modifier = modifier) {
        items(articulo) { articul ->
            ArticuloRow(articul, viewModel)
        }
    }
}

@Composable
fun ArticuloRow(articulo: Articuloentity, viewModel: ArticuloListViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = "Descripcion ${articulo.Descripcion}",
            style = MaterialTheme.typography.subtitle1
        )

        Text(
            text = "Marca ${articulo.Marca}",
            style = MaterialTheme.typography.subtitle1
        )

        Text(
            text = "Existencia ${articulo.Existencia}",
            style = MaterialTheme.typography.subtitle1
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            IconButton(
                modifier = Modifier.padding(0.dp),
                onClick = { }) {
                Icon(imageVector = Icons.Outlined.Clear, contentDescription = "Eliminar",
                    tint = Color.Red)
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}


























//isDigitOnly
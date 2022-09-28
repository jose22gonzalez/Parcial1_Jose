package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.IconButton
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList.ArticuloListViewModel



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
            PantallaList(

            )

        }
    }


}

@Composable
fun PantallaList(

    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {

    }
}

@Composable
fun PantallaRow() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = "Algo",
            style = MaterialTheme.typography.h1
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Algo"
            )
            IconButton(
                modifier = Modifier.padding(0.dp),
                onClick = {}) {
                Icon(imageVector = Icons.Outlined.Clear, contentDescription = "Editar",
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
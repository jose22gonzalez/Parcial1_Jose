package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.IconButton
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallalistScreen(
    onClick: () ->Unit,
) {
    Scaffold (
        topBar = {CenterAlignedTopAppBar(title = {Text("Pantalla List")})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a Examen")
            }

        },

        ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {

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
            style = MaterialTheme.typography.titleLarge
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
                Icon(imageVector = Icons.Outlined.Clear, contentDescription = "Clear",
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
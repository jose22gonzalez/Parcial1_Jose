package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.parcial1_jose.data.Remote.dto.ArticuloResponseDTO


@Composable
fun PantallaScreen(
    articuloId: Int = 0,
    viewModel: ArticuloScreenViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit
) {

//    Log.i("parametro", articuloId.toString())
//    val id = remember(articuloId) {
//        viewModel.FindArticulo(articuloId)
//        0
//    }

//    val uiState by viewModel.UiState.collectAsState()
//   if (articuloId > 0){
//       viewModel.FindArticulo(articuloId)
//        Mostrar(onNavigateBack, articuloId)
//   }else{
//
//   }
    FormUser(onNavigateBack, articuloId)
//    Mostrar(articuloResponseDTO = uiState.Onearticulo, onNavigateBack, articuloId)

    viewModel.id = articuloId.toString()


}

@Composable
fun Mostrar(
//    articuloResponseDTO: ArticuloResponseDTO,
    onNavigateBack: () -> Unit,
    articuloId: Int,
    viewModel: ArticuloScreenViewModel = hiltViewModel())
{

//    LazyColumn(modifier = Modifier) {
//        items(articuloResponseDTO) {articulo ->
//            MostarEnd(articuloResponseDTO = articulo, onNavigateBack, articuloId)
//        }
//    }
}

@Composable
fun MostarEnd(articuloResponseDTO: ArticuloResponseDTO,onNavigateBack: () -> Unit,articuloId: Int, viewModel: ArticuloScreenViewModel = hiltViewModel()){
    var context = LocalContext.current
    fun Validar() {
        if(viewModel.Descripcion.isBlank() || viewModel.Marca.isBlank() || viewModel.Marca.isBlank() || viewModel.Marca.isDigitsOnly()){
            Toast.makeText(
                context,
                "Error, No se puede Guardar",
                Toast.LENGTH_LONG
            ).show()
        }else{
            viewModel.save()
            onNavigateBack()
        }
    }
    Scaffold (
        topBar = { Text(
            text = "Registro Articulos",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(5.dp)
        )},
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(10.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.id,
                label = { Text(text = "Id")},
                onValueChange = {viewModel.id = it}
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.Descripcion,
                label = { Text(text = "Descripcion")},
                onValueChange = {viewModel.Descripcion = it}
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.Marca,
                label = { Text(text = "Marca")},
                onValueChange = {viewModel.Marca = it}
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.Precio,
                label = { Text(text = "Precio")},
                onValueChange = {viewModel.Precio = it}
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.Existencia,
                label = { Text(text = "Existencia")},
                onValueChange = {viewModel.Existencia = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )

            )


            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                onClick = {
                    Validar()
                }) {
                Text(text = "Add a Articulo")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                onClick = {
//                    viewModel.FindArticulo(articuloId)
                }) {
                Text(text = "Add a Articulo")
            }

        }
    }
}

@Composable
fun FormUser(onNavigateBack: () -> Unit,articuloId: Int, viewModel: ArticuloScreenViewModel = hiltViewModel()) {
    var context = LocalContext.current
    fun Validar() {
        if(viewModel.Descripcion.isBlank() || viewModel.Marca.isBlank() || viewModel.Marca.isBlank() || viewModel.Marca.isDigitsOnly()){
            Toast.makeText(
                context,
                "Error, No se puede Guardar",
                Toast.LENGTH_LONG
            ).show()
        }else{
            viewModel.save()
            onNavigateBack()
        }
    }
    Scaffold (
        topBar = { Text(
            text = "Registro Articulos",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(5.dp)
        )},
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(10.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.id,
                label = { Text(text = "Id")},
                onValueChange = {viewModel.id = it}
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.Descripcion,
                label = { Text(text = "Descripcion")},
                onValueChange = {viewModel.Descripcion = it}
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.Marca,
                label = { Text(text = "Marca")},
                onValueChange = {viewModel.Marca = it}
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.Precio,
                label = { Text(text = "Precio")},
                onValueChange = {viewModel.Precio = it}
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                value = viewModel.Existencia,
                label = { Text(text = "Existencia")},
                onValueChange = {viewModel.Existencia = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )

            )


            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                onClick = {
                    Validar()
                }) {
                Text(text = "Add a Articulo")
            }


        }
    }
}

//LazyColumn(modifier = Modifier.fillMaxSize()) {
//    items(articulo) { articul ->
//        ArticuloRow(articul, viewModel){articuloId ->
//            onNavigateToArticulo(articuloId)
//        }
//    }
//}
package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_jose.data.entity.Articuloentity
import edu.ucne.parcial1_jose.data.respository.Articulorespository
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ArticuloScreenViewModel @Inject constructor(
    val respository: Articulorespository
): ViewModel() {
    var Descripcion by mutableStateOf("")
    var Marca by mutableStateOf("")
    var Existencia by mutableStateOf("")

    fun save(){
        viewModelScope.launch {
            respository.Insertandoarticulo(
                Articuloentity(
                    Descripcion = Descripcion,
                    Marca = Marca,
                    Existencia = Existencia.toInt()
                )
            )
        }

    }
}



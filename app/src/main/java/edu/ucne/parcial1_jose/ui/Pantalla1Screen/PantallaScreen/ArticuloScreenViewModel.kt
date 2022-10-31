package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaScreen

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_jose.data.Remote.dto.ArticuloResponseDTO
import edu.ucne.parcial1_jose.data.Remote.respository.ArticuloApirespository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import javax.inject.Inject

//data class ArticuloListUIStatE(
//    val Onearticulo: ArticuloResponseDTO = ArticuloResponseDTO(
//        articuloId = 0,
//        descripcion = "",
//        marca = "",
//        precio = 0.0,
//        existencia = 0
//    )
//)

@HiltViewModel
class ArticuloScreenViewModel @Inject constructor(
    private val apirespository: ArticuloApirespository
): ViewModel() {

//    private val _uiState = MutableStateFlow(ArticuloListUIStatE())
//    val UiState: StateFlow<ArticuloListUIStatE> = _uiState.asStateFlow()

    var id by mutableStateOf("")
    var Descripcion by mutableStateOf("")
    var Marca by mutableStateOf("")
    var Precio by mutableStateOf("")
    var Existencia by mutableStateOf("")



    fun save(){
        viewModelScope.launch {
            apirespository.InsertarArticuloApi(
                ArticuloResponseDTO(
                    ariticuloId = 0,
                    descripcion = Descripcion,
                    marca = Marca,
                    precio = Precio.toDouble(),
                    existencia = Existencia.toDouble()
                )
            )
        }

    }

//    fun FindArticulo(Id: Int){
//
//            viewModelScope.launch {
//                _uiState.getAndUpdate {
//                    it.copy(apirespository.GetArticulo(Id))
//                }
//            }
//    }



    fun UpdateArticulo(Id: Int, articuloResponseDTO: ArticuloResponseDTO){
        viewModelScope.launch {
            apirespository.UpdateArticulo(Id,
                    ArticuloResponseDTO(
                        ariticuloId = id.toInt(),
                        descripcion = Descripcion,
                        marca = Marca,
                        precio = Precio.toDouble(),
                        existencia = Existencia.toDouble()
                    )
                )
        }
    }

}






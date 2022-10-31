package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_jose.data.Remote.dto.ArticuloResponseDTO
import edu.ucne.parcial1_jose.data.Remote.respository.ArticuloApirespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArticuloListUIState(
    val articulo: List<ArticuloResponseDTO> = emptyList(),
)

@HiltViewModel
class ArticuloListViewModel @Inject constructor(
   private val apiarticulo: ArticuloApirespository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ArticuloListUIState())
    val uiState: StateFlow<ArticuloListUIState> = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
            _uiState.getAndUpdate {
                it.copy(articulo = apiarticulo.getListArticulos().sortedBy { it.ariticuloId })
            }
        }
    }

    fun Delete(Id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            apiarticulo.EliminarArticuloApi(Id)
        }
    }



/*    init {
        viewModelScope.launch {
            respositorio.listArticulo().collect{list ->
                _uiState.update {
                    it.copy(articulo = list)
                }
            }
        }
    }

    fun Delete(articuloentity: Articuloentity) {
        viewModelScope.launch(Dispatchers.IO) {
            respositorio.Elimandoarticulo(articuloentity)
        }
    }*/
}
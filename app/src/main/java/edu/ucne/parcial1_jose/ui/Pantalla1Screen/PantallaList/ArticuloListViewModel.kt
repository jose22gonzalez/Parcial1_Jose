package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImagePainter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import edu.ucne.parcial1_jose.data.entity.Articuloentity
import edu.ucne.parcial1_jose.data.respository.Articulorespository


data class PantallaListUIState(
    val articulo: List<Articuloentity> = emptyList(),
)

@HiltViewModel
class ArticuloListViewModel @Inject constructor(
    val respositorio: Articulorespository
) : ViewModel() {
    private val _uiState = MutableStateFlow(PantallaListUIState())
    val uiState: StateFlow<PantallaListUIState> = _uiState.asStateFlow()

    init {
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
    }
}
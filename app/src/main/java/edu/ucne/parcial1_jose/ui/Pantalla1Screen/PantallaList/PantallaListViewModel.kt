package edu.ucne.parcial1_jose.ui.Pantalla1Screen.PantallaList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImagePainter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import edu.ucne.parcial1_jose.data.entity.Examenentity



data class PantallaListUIState(
    val examen: List<Examenentity> = emptyList(),
)

@HiltViewModel
class PantallaListViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow(PantallaListUIState())
    val uiState: StateFlow<PantallaListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {

        }
    }

    fun Delete(examenentity: Examenentity) {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}
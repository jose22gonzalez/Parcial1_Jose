package edu.ucne.parcial1_jose.data.Remote.dto

data class ArticuloResponseDTO(
//   @Json(name = "articuloId")
    val ariticuloId: Int,
    val descripcion: String,
    val marca: String,
    val precio: Double,
    val existencia: Double,
)

//Ctrl + Shif + / --> Comentar


package edu.ucne.parcial1_jose.data.Remote

import edu.ucne.parcial1_jose.data.Remote.dto.ArticuloResponseDTO
import retrofit2.Response
import retrofit2.http.*


interface ApiArticulo {

    @GET("api/Articulos")
    suspend fun GetList(): Response<List<ArticuloResponseDTO>>

    @POST("api/Articulos")
    suspend fun InsertarArticuloAPI(@Body articuloResponseDTO: ArticuloResponseDTO): Response<List<ArticuloResponseDTO>>

    @GET("api/Articulos/{Id}")
    suspend fun GetArticulo(@Path("Id") Id: Int): Response<List<ArticuloResponseDTO>>

    @PUT("api/Articulos/{Id}")
    suspend fun UpdateArticulo(@Path("Id") Id: Int, @Body articuloResponseDTO: ArticuloResponseDTO): Response<List<ArticuloResponseDTO>>

    @DELETE("api/Articulos/{Id}")
    suspend fun EliminarArticuloAPI(@Path("Id") Id: Int): Response<List<ArticuloResponseDTO>>
}
package edu.ucne.parcial1_jose.data.Remote.respository

import edu.ucne.parcial1_jose.data.Remote.ApiArticulo
import edu.ucne.parcial1_jose.data.Remote.dto.ArticuloResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class ArticuloApirespository @Inject constructor(
    private val api: ApiArticulo
){
   suspend fun getListArticulos(): List<ArticuloResponseDTO> {
        try {
            return withContext(Dispatchers.IO){
                val response = api.GetList()
                response.body()?: emptyList()
            }
        } catch (e: Exception) {
            throw e
        }
    }

//    suspend fun GetArticulo(articuloId: Int): List<ArticuloResponseDTO>{
//        try {
//            return withContext(Dispatchers.IO){
//                val response = api.GetArticulo(articuloId)
//                response.boddy()?: emptyList()
//            }
//        }catch (e: Exception){
//            throw e
//        }
//    }
suspend fun GetArticulo(articuloId: Int) = api.GetArticulo(articuloId)

    suspend fun UpdateArticulo(Articuloid: Int, articuloResponseDTO: ArticuloResponseDTO) {
        try {
            return withContext(Dispatchers.IO) {
                val response = api.UpdateArticulo(Articuloid, articuloResponseDTO)
                response.body()?: emptyList()
            }
        } catch (e: Exception) {
            throw  e
        }
    }

    suspend fun InsertarArticuloApi(articuloResponseDTO: ArticuloResponseDTO): List<ArticuloResponseDTO> {
        try {
            return withContext(Dispatchers.IO){
                val response = api.InsertarArticuloAPI(articuloResponseDTO)
                response.body()?: emptyList()
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun EliminarArticuloApi(Id: Int) = api.EliminarArticuloAPI(Id)



}



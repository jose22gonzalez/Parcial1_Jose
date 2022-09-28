package edu.ucne.parcial1_jose.data.respository

import androidx.room.Dao
import edu.ucne.parcial1_jose.data.dao.ArticuloDao
import edu.ucne.parcial1_jose.data.entity.Articuloentity
import javax.inject.Inject


@Dao
class Articulorespository @Inject constructor(
    val db: ArticuloDao
){
    suspend fun Insertandoarticulo(articuloentity: Articuloentity){
        db.InsertaArticulo(articuloentity)
    }

    suspend fun Actualizandoarticulo(articuloentity: Articuloentity){
        db.ActualizarArticulo(articuloentity)
    }

    suspend fun Elimandoarticulo(articuloentity: Articuloentity){
        db.EliminarArticulo(articuloentity)
    }
}
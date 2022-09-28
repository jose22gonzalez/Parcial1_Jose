package edu.ucne.parcial1_jose.data.respository

import androidx.room.Dao
import edu.ucne.parcial1_jose.data.ExamenDatabase
import edu.ucne.parcial1_jose.data.dao.ArticuloDao
import edu.ucne.parcial1_jose.data.entity.Articuloentity
import javax.inject.Inject



class Articulorespository @Inject constructor(
    val db  : ExamenDatabase
){
    suspend fun Insertandoarticulo(articuloentity: Articuloentity){
     db.ArticuloDao.InsertaArticulo(articuloentity)
    }

    suspend fun Actualizandoarticulo(articuloentity: Articuloentity){
        db.ArticuloDao.ActualizarArticulo(articuloentity)
    }

    suspend fun Elimandoarticulo(articuloentity: Articuloentity){
       db.ArticuloDao.EliminarArticulo(articuloentity)
    }

    fun listArticulo() = db.ArticuloDao.ListArticulo()

    fun findArticulo(id: Int) = db.ArticuloDao.FindArticulo(id)
}
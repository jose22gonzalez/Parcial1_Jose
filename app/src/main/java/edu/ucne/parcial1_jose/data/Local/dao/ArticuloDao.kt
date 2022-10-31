package edu.ucne.parcial1_jose.data.Local.dao

import androidx.room.*
import edu.ucne.parcial1_jose.data.Local.entity.Articuloentity
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticuloDao {

    @Insert
    suspend fun InsertaArticulo(articuloentity: Articuloentity)

    @Update
    suspend fun ActualizarArticulo(articuloentity: Articuloentity)

    @Delete
    suspend fun EliminarArticulo(articuloentity: Articuloentity)

    @Query("SELECT * FROM Articulos WHERE ArticuloId = :id")
    fun FindArticulo(id: Int): Flow<Articuloentity>

    @Query("SELECT * FROM Articulos")
    fun ListArticulo(): Flow<List<Articuloentity>>

}
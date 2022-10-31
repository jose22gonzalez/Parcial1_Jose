package edu.ucne.parcial1_jose.data.Local.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Articulos")
data class Articuloentity (
    @PrimaryKey(autoGenerate = true)
    val ArticuloId: Int = 0,
    val Descripcion: String = "",
    val Marca: String,
    val Existencia: Int
)
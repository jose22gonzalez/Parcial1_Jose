package edu.ucne.parcial1_jose.data.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Parcial1")
data class Examenentity (
    @PrimaryKey(autoGenerate = true)
    val parcialId: Int = 0,
    val descripcion: String = "",
    val descripcion2: String,
    val nota: Double
)
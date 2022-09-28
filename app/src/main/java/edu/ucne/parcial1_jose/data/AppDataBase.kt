package edu.ucne.parcial1_jose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_jose.data.dao.ArticuloDao
import edu.ucne.parcial1_jose.data.entity.Articuloentity


@Database(
    entities = [Articuloentity::class],
    version = 2,
    exportSchema = false
)
abstract class ExamenDatabase: RoomDatabase(){
    abstract val ArticuloDao: ArticuloDao
}
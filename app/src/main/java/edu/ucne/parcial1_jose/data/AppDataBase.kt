package edu.ucne.parcial1_jose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_jose.data.entity.Examenentity

@Database(
    entities = [Examenentity::class],
    version = 2,
    exportSchema = false
)
abstract class ExamenDatabase: RoomDatabase(){

}
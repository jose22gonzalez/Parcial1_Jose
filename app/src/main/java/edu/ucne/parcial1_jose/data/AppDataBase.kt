package edu.ucne.parcial1_jose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.parcial1_jose.data.entity.Examenentity

@Database(
    entities = [Examenentity::class],
    version = 1,
    exportSchema = false
)
abstract class ExamenDatabase: RoomDatabase(){


}
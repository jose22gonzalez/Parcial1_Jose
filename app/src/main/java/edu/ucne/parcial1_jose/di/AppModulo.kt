package edu.ucne.parcial1_jose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcial1_jose.data.ExamenDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModulo {
    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context: Context): ExamenDatabase {
        return Room.databaseBuilder(
            context,
            ExamenDatabase::class.java,
            "ArticulosDB"
        ).fallbackToDestructiveMigration().build()
    }
}
package edu.ucne.parcial1_jose.di

import android.content.Context
import androidx.room.Room
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcial1_jose.data.ExamenDatabase
import edu.ucne.parcial1_jose.data.Remote.ApiArticulo
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
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

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun providesArticuloApi(moshi: Moshi): ApiArticulo {
        return Retrofit.Builder()
            .baseUrl("http://www.apiprestamos.somee.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiArticulo::class.java)
    }

}
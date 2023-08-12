package com.example.jorge_castroexamen_final.Model.Local.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantDetailEntity
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantEntity
import com.example.jorge_castroexamen_final.Model.Local.PlantDAO


// Creacion de base de datos según entidades declaradas
@Database(
    entities = [PlantEntity::class, PlantDetailEntity::class],
    version = 1,
    exportSchema = false
)
// Declaracion de clase abstracta
abstract class PlantDataBase : RoomDatabase() {

    // Instancia del DAO
    abstract fun getPlantDAO(): PlantDAO

    companion object {

        @Volatile
        private var
                INSTANCE: PlantDataBase? = null

        fun getDataBase(context: Context): PlantDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDataBase::class.java, "plantDb"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
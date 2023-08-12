package com.example.jorge_castroexamen_final.Model.Local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantDetailEntity
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantEntity


@Dao
interface PlantDAO {

    // Declaración de funciones a utilizar en la base de datos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPlant(plantList: List<PlantEntity>)

    @Query("SELECT * FROM PLANT_TABLE ORDER BY id ASC")
    fun getAllPlant(): LiveData<List<PlantEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlantDetail(plant: PlantDetailEntity)

    @Query("SELECT * FROM PLANT_DETAIL_TABLE WHERE id=:id")
    fun getPlantDetailById(id: String): LiveData<PlantDetailEntity>
}
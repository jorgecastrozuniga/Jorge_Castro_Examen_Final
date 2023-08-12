package com.example.jorge_castroexamen_final.Model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantDetailEntity
import com.example.jorge_castroexamen_final.Model.Local.PlantDAO
import com.example.jorge_castroexamen_final.Model.Remoto.RetrofitClient


class PlantRepository(private val plantDAO: PlantDAO) {

    // Implementacion de las instancias
    private val retrofitClient = RetrofitClient.retrofitInstance()
    val plantListLiveData = plantDAO.getAllPlant()
    val plantDetailListLiveData = MutableLiveData<PlantDetailEntity>()

    // Funcion que toma los datos
    suspend fun fetchPlant() {

        val service = kotlin.runCatching { retrofitClient.fetchPlantList() }

        service.onSuccess {
            when (it.code()) {
                in 200..299 -> it.body()?.let {
                    plantDAO.insertAllPlant(fromInternetPlantEntity(it))
                }

                else -> Log.d("Prueba 01", "${it.code()}-${it.errorBody()}")
            }
            service.onFailure {
                Log.e("<<<<<<Error>>>>>>>", "${it.message}")
            }
        }
    }

    // Funcion que obtiene los datos de PlantDetail
    suspend fun fetchPlantDetail(id: String): PlantDetailEntity? {
        val service = kotlin.runCatching { retrofitClient.fetchPlantDetail(id) }
        return service.getOrNull()?.body()?.let { plantDetail ->
            val plantDetailEntity = fromInternetPlantDetailEntity(plantDetail)
            plantDAO.insertPlantDetail(plantDetailEntity)
            plantDetailEntity
        }
    }
}
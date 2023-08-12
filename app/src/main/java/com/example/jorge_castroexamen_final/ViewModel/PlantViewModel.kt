package com.example.jorge_castroexamen_final.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jorge_castroexamen_final.Model.Local.DataBase.PlantDataBase
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantDetailEntity
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantEntity
import com.example.jorge_castroexamen_final.Model.Local.PlantDAO
import com.example.jorge_castroexamen_final.Model.PlantRepository
import kotlinx.coroutines.launch


class PlantViewModel(application: Application) : AndroidViewModel(application) {

    // Declaracion de Instancias
    private val repository: PlantRepository
    private val plantDetailLiveData = MutableLiveData<PlantDetailEntity>()

    // Variable para guardar el ID seleccionado
    private var idSelected: String = "-1"

    // Inicializacion de variables
    init {
        val PlantDAO = PlantDataBase.getDataBase(application).getPlantDAO()
        repository = PlantRepository(PlantDAO)
        viewModelScope.launch {
            repository.fetchPlant()
        }
    }

    // Llamado a las funciones desde el repositorio y activacion las funciones suspendidas
    fun getPlantList(): LiveData<List<PlantEntity>> = repository.plantListLiveData

    fun getPlantDetail(): LiveData<PlantDetailEntity> = plantDetailLiveData

    fun getPlantDetailByIdFromInternet(id: String) = viewModelScope.launch {

        val plantDetail = repository.fetchPlantDetail(id)
        plantDetail?.let {
            plantDetailLiveData.postValue(it)
        }
    }
}


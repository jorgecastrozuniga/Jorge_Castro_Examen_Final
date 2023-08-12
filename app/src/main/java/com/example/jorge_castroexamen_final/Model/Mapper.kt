package com.example.jorge_castroexamen_final.Model

import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantDetailEntity
import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantEntity
import com.example.jorge_castroexamen_final.Model.Remoto.DesdeInternet.Plant
import com.example.jorge_castroexamen_final.Model.Remoto.DesdeInternet.PlantDetail

// Declaracion de funciones que unen elementos remotos con elementos locales
fun fromInternetPlantEntity(plantList: List<Plant>): List<PlantEntity> {

    return plantList.map {
        PlantEntity(
            id = it.id,
            nombre = it.nombre,
            tipo = it.tipo,
            imagen = it.imagen,
            descripcion = it.descripcion
        )
    }
}

fun fromInternetPlantDetailEntity(plant: PlantDetail): PlantDetailEntity {

    return PlantDetailEntity(
        id = plant.id,
        nombre = plant.nombre,
        tipo = plant.tipo,
        imagen = plant.imagen,
        descripcion = plant.descripcion
    )
}
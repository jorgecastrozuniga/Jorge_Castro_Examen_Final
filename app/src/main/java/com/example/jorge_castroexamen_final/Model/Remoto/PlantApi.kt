package com.example.jorge_castroexamen_final.Model.Remoto

import com.example.jorge_castroexamen_final.Model.Remoto.DesdeInternet.Plant
import com.example.jorge_castroexamen_final.Model.Remoto.DesdeInternet.PlantDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


// Interface que se comunica con Api a través de 2 endpoints
interface PlantApi {

    @GET("plantas")
    suspend fun fetchPlantList(): Response<List<Plant>>

    @GET("plantas/{id}")
    suspend fun fetchPlantDetail(@Path("id") id: String): Response<PlantDetail>
}
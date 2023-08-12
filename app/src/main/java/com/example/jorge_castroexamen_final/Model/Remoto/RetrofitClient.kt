package com.example.jorge_castroexamen_final.Model.Remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Declaracion de clase RetrofitClient
class RetrofitClient {

    companion object {

        private const val BASE_URL = "https://my-json-server.typicode.com/mauricioponce/TDApi/"

        lateinit var retrofitInstance: Retrofit

        fun retrofitInstance(): PlantApi {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(PlantApi::class.java)
        }
    }
}
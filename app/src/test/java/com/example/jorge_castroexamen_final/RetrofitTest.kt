package com.example.jorge_castroexamen_final

import com.example.jorge_castroexamen_final.Model.Remoto.RetrofitClient
import junit.framework.TestCase.assertEquals
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitTest {

    private lateinit var mockWebServer: MockWebServer


    // Primero el antes utilizando mockWebServer
    @Before
    fun setup() {
        mockWebServer = MockWebServer()
    }

    // Despues apagamos el mockWebServer
    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    // Implementacion de la prueba
    @Test
    fun testRetrofit() {

        // Entregamos una base url
        val expectedBaseUrl = mockWebServer.url("a/").toString()

        val retrofit = Retrofit.Builder()
            .baseUrl(expectedBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Asignar la instancia real de retrofit a la propiedad retrofitIntance de Retrofitcliente
        RetrofitClient.retrofitInstance = retrofit
        val retrofitInstance = RetrofitClient.retrofitInstance
        assertEquals(expectedBaseUrl, retrofitInstance.baseUrl().toString())
    }
}
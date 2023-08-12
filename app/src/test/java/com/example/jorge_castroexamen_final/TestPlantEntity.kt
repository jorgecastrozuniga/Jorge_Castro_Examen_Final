package com.example.jorge_castroexamen_final

import com.example.jorge_castroexamen_final.Model.Local.Entidades.PlantEntity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TestPlantEntity {

    // Declaracion de variables
    private lateinit var plantEntity: PlantEntity

    @Before
    fun setup() {

        plantEntity = PlantEntity(

            id = 1,
            nombre = "Prueba Unitario",
            tipo = "plantas",
            imagen = "imagen",
            descripcion = "descripcion"
        )
    }


    @After
    fun tearDown() {
        // acciones de limpieza y liberacion de recursos
    }


    @Test
    fun testPlantConstructor() {

        // Corroborar que los valores asignados en el constructor sean los correctos
        assert(plantEntity.id == 1)
        assert(plantEntity.tipo == "plantas")
        assert(plantEntity.imagen == "imagen")
        assert(plantEntity.descripcion == "descripcion")
    }
}
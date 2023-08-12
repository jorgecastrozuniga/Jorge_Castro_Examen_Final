package com.example.jorge_castroexamen_final.Model.Remoto.DesdeInternet

import androidx.room.Entity
import androidx.room.PrimaryKey


// Definicion de Data class
class PlantDetail(

// Declaración de variables
    val id: Int,
    val nombre: String,
    val tipo: String,
    val imagen: String,
    val descripcion: String
)
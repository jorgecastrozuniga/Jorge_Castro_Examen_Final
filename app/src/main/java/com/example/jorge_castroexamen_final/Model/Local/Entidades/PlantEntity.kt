package com.example.jorge_castroexamen_final.Model.Local.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey


// Declaración de Entidad
@Entity(tableName = "plant_table")
class PlantEntity(

// Declaración de variables
    @PrimaryKey
    val id: Int,
    val nombre: String,
    val tipo: String,
    val imagen: String,
    val descripcion: String

)
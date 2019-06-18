package com.example.animalcare.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "ley_table")
data class ley_entity (
    @PrimaryKey @ColumnInfo (name = "id") val id: String,
    @field:Json(name="nombre_ley")
    @ColumnInfo(name = "nombre_ley") val nombre_ley: String,
    @field:Json(name="descripcion_ley")
    @ColumnInfo(name = "descripcion_ley") val descripcion_ley: String
    )
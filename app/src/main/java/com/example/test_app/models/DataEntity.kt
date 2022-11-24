package com.example.test_app.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class DataEntity(
    @PrimaryKey
    val id: String,
    val id_hd_route: Int,
    val id_pos: Int,
    val id_record: Int,
    val nom_nakl: String,
    val nom_route: String,
    val nom_zak: String
)
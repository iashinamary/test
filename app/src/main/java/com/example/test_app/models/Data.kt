package com.example.test_app.models

import java.util.*

data class Data(
    val id_hd_route: Int,
    val id_pos: Int,
    val id_record: Int,
    val nom_nakl: String?,
    val nom_route: String,
    val nom_zak: String
)

fun Data.toDataEntity(): DataEntity {
    return DataEntity(UUID.randomUUID().toString(), id_hd_route, id_pos, id_record,
    nom_nakl, nom_route, nom_zak)
}
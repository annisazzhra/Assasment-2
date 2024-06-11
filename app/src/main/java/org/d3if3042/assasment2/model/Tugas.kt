package org.d3if3042.assasment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tugas")
data class Tugas(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val judul: String,
    val deskripsi: String,
    val tanggalJatuhTempo: String,
    val statusSelesai: Boolean
)

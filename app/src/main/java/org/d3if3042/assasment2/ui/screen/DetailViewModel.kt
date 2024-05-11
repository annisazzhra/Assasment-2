package org.d3if3042.assasment2.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if3042.assasment2.model.Tugas

class DetailViewModel : ViewModel() {

    fun getTugas(id: Long): Tugas {
        // Contoh pengembalian data tugas statis untuk keperluan demonstrasi
        return Tugas(
            id,
            "Tugas Mobpro $id",
            "Deskripsi tugas Mobpro $id",
            "2024-05-11", // Tanggal jatuh tempo dapat diubah sesuai kebutuhan
            false // Status awal belum selesai
        )
    }
}
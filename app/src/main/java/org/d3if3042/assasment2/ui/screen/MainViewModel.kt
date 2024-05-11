package org.d3if3042.assasment2.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if3042.assasment2.model.Tugas

class MainViewModel : ViewModel() {

    val data = getDataDummy()

    private fun getDataDummy(): List<Tugas> {
        val data = mutableListOf<Tugas>()
        for (i in 29 downTo 20 ) {
            data.add(
                Tugas(
                    i.toLong(),
                    "Tugas Mobpro $i",
                    "Deskripsi tugas Mobpro $i",
                    "2024-02-$i 12:34:56",
                    false // Status awal belum selesai
                )
            )
        }
        return data
    }
}

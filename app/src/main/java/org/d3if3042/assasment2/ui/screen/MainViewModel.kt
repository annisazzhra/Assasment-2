package org.d3if3042.assasment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3042.assasment2.database.TugasDao
import org.d3if3042.assasment2.model.Tugas

class MainViewModel(dao: TugasDao) : ViewModel() {

    val data: StateFlow<List<Tugas>> = dao.getTugas().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

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

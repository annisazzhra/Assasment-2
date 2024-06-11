package org.d3if3042.assasment2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3042.assasment2.database.TugasDao
import org.d3if3042.assasment2.model.Tugas
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: TugasDao) : ViewModel() {
    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(judul: String, deskripsi: String) {
        val tugas = Tugas(
            tanggalJatuhTempo = formatter.format(Date()),
            judul = judul,
            deskripsi = ""
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(tugas)
        }
    }
//    fun getTugas(id: Long): Tugas {
//        // Contoh pengembalian data tugas statis untuk keperluan demonstrasi
//        return Tugas(
//            id,
//            "Tugas Mobpro $id",
//            "Deskripsi tugas Mobpro $id",
//            "2024-05-11", // Tanggal jatuh tempo dapat diubah sesuai kebutuhan
//            false // Status awal belum selesai
//        )
//    }
    suspend fun getTugas(id: Long): Tugas? {
        return dao.getTugasById(id)
    }
    fun update(id: Long, judul: String, deskripsi: String) {
        val tugas = Tugas(
            id = id,
            tanggalJatuhTempo = formatter.format(Date()),
            judul = judul,
            deskripsi = ""
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(tugas)
        }
        fun delete(id: Long, statusSelesai: Boolean = false) {
            viewModelScope.launch(Dispatchers.IO) {
                dao.deleteById(id)
            }
        }
    }
}
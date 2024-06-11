package org.d3if3042.assasment2.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3042.assasment2.database.TugasDao
import org.d3if3042.assasment2.ui.screen.DetailViewModel
import org.d3if3042.assasment2.ui.screen.MainViewModel

class ViewModelFactory(private val dao: TugasDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

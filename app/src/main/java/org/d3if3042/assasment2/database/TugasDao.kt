package org.d3if3042.assasment2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3042.assasment2.model.Tugas

@Dao
interface TugasDao {

    @Insert
    suspend fun insert(tugas: Tugas)

    @Update
    suspend fun update(tugas: Tugas)

    @Query("SELECT * FROM tugas ORDER BY statusSelesai DESC")
    fun getTugas(): Flow<List<Tugas>>

    @Query("SELECT * FROM tugas WHERE id = :id")
    suspend fun getTugasById(id: Long): Tugas?

    @Query("DELETE FROM tugas WHERE id = :id")
    suspend fun deleteById(id: Long)
}
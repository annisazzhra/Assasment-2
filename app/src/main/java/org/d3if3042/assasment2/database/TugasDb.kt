package org.d3if3042.assasment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3042.assasment2.model.Tugas

@Database(entities = [Tugas::class], version = 1, exportSchema = false)
abstract class TugasDb : RoomDatabase(){

    abstract val dao: TugasDao

    companion object {

        @Volatile
        private var INSTANCE: TugasDb? = null
        fun getInstance(context: Context): TugasDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TugasDb::class.java,
                        "tugas.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
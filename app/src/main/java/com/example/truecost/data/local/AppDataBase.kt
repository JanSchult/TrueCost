package com.example.truecost.data.local
import com.example.truecost.data.model.LifeCostEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LifeCostEntity::class], version = 1, exportSchema = false)

abstract class LifeCostDatabase : RoomDatabase() {
    abstract fun lifecostdao(): LifeCostDao


    companion object {
        @Volatile
        private var Instance: LifeCostDatabase? = null

        fun getDatabase(context: Context): LifeCostDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, LifeCostDatabase::class.java, "life_cost_database")
                    .build().also { Instance = it }
            }
        }
    }
}

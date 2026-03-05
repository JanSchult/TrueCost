package com.example.truecost.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.truecost.data.model.LifeCostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LifeCostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(lifeCost: LifeCostEntity)

    @Query("SELECT * FROM life_costs ORDER BY createdAt DESC")
    fun getAll(): Flow<List<LifeCostEntity>>

    @Query("DELETE FROM life_costs")
    suspend fun clearAll()
}
package com.example.truecost.data.remote

import com.example.truecost.data.local.LifeCostDao
import com.example.truecost.data.model.LifeCostEntity
import kotlinx.coroutines.flow.Flow

class LifeCostRepository(
    private val dao: LifeCostDao
) {

    suspend fun save(entity: LifeCostEntity) {
        dao.insert(entity)
    }

    fun getAll(): Flow<List<LifeCostEntity>> {
        return dao.getAll()
    }

    suspend fun clear() {
        dao.clearAll()
    }
}
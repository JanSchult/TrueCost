package com.example.truecost.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "life_costs")
data class LifeCostEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val productName: String,
    val productPrice: Double,
    val lifeHoursDecimal: Double,
    val createdAt: Long
)
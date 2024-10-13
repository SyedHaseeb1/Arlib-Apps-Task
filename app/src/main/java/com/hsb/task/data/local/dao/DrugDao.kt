package com.hsb.task.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hsb.task.data.model.DrugEntity

@Dao
interface DrugDao {
    @Query("SELECT * FROM drugs")
    suspend fun getAllDrugs(): List<DrugEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(drugs: List<DrugEntity>)
}
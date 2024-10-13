package com.hsb.task.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hsb.task.data.model.LabEntity

@Dao
interface LabDao {
    @Query("SELECT * FROM labs")
    suspend fun getAllLabs(): List<LabEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(labs: List<LabEntity>)
}

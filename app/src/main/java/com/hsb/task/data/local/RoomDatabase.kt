package com.hsb.task.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hsb.task.data.local.dao.DrugDao
import com.hsb.task.data.local.dao.LabDao
import com.hsb.task.data.model.DrugEntity
import com.hsb.task.data.model.LabEntity

@Database(entities = [DrugEntity::class, LabEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun drugDao(): DrugDao
    abstract fun labDao(): LabDao
}

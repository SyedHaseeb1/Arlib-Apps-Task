package com.hsb.task.test

import com.hsb.task.data.local.AppDatabase
import com.hsb.task.data.local.dao.DrugDao
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hsb.task.data.model.DrugEntity
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlinx.coroutines.runBlocking

@RunWith(AndroidJUnit4::class)
class DrugDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var drugDao: DrugDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        drugDao = database.drugDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun `insert drug entity should succeed`() = runBlocking {
        // Arrange
        val drugEntity =
            DrugEntity(name = "Ibuprofen", dose = "200mg", strength = "200mg", problemName = "Pain")

        // Act
        drugDao.insertAll(listOf(drugEntity))
        val drugs = drugDao.getAllDrugs()

        // Assert
        assertEquals(1, drugs.size)
        assertEquals("Ibuprofen", drugs[0].name)
    }
}

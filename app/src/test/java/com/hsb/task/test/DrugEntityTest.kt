package com.hsb.task.test

import com.hsb.task.data.model.Drug
import com.hsb.task.data.model.toDomainModel

import org.junit.Assert.assertEquals
import org.junit.Test

class DrugEntityTest {

    @Test
    fun `Drug should convert to DrugEntity correctly`() {
        // Arrange
        val drug = Drug(name = "Aspirin", dose = "100mg", strength = "100mg", problemName = "Pain")

        // Act
        val drugEntity = drug.toDomainModel()

        // Assert
        assertEquals(drug.name, drugEntity.name)
        assertEquals(drug.dose, drugEntity.dose)
        assertEquals(drug.strength, drugEntity.strength)
        assertEquals(drug.problemName, drugEntity.problemName)
    }
}

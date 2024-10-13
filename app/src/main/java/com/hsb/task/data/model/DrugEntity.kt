package com.hsb.task.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drugs")
data class DrugEntity(
    @PrimaryKey val name: String,
    val dose: String?,
    val strength: String?,
    val problemName: String
)

// Extension function to convert DrugEntity to Drug domain model
fun DrugEntity.toDomainModel(): Drug {
    return Drug(
        name = this.name,
        dose = this.dose,
        strength = this.strength,
        problemName = this.problemName
    )
}
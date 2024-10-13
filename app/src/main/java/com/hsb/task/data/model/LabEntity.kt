package com.hsb.task.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "labs")
data class LabEntity(
    @PrimaryKey val name: String,
    val result: String,
    val problemName: String
)
// Extension function to convert LabEntity to Lab domain model
fun LabEntity.toDomainModel(): Lab {
    return Lab(
        name = this.name,
        result = this.result,
        problemName = this.problemName
    )
}
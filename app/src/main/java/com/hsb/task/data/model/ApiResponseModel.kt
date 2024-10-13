package com.hsb.task.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val problems: List<Problem>
)

@Serializable
data class Problem(
    val Diabetes: List<Diabetes> = emptyList(),
    val Asthma: List<Asthma> = emptyList()
)

@Serializable
sealed class Condition {
    abstract val medications: List<Medication>
    abstract val labs: List<Lab>
}

@Serializable
data class Diabetes(
    override val medications: List<Medication>,
    override val labs: List<Lab>
) : Condition()

@Serializable
data class Asthma(
    override val medications: List<Medication> = emptyList(),
    override val labs: List<Lab> = emptyList()
) : Condition()

@Serializable
data class Medication(
    val medicationsClasses: List<MedicationClass> = emptyList()
)

@Serializable
data class MedicationClass(
    val className: List<ClassNameGroup> = emptyList(),
    val className2: List<ClassNameGroup> = emptyList()
)

@Serializable
data class ClassNameGroup(
    val associatedDrug: List<Drug> = emptyList(),
    @SerializedName("associatedDrug#2")
    val associatedDrug2: List<Drug> = emptyList()
)

@Serializable
data class Drug(
    val name: String,
    val dose: String?,
    val strength: String?,
    val problemName: String
)
fun Drug.toDomainModel(): DrugEntity {
    return DrugEntity(
        name = this.name,
        dose = this.dose,
        strength = this.strength,
        problemName = this.problemName
    )
}
@Serializable
data class Lab(
    val name: String? = null,
    val value: String? = null,
    val normalRange: String? = null,
    val result: String = "",
    val problemName: String? = null
)

@Serializable
data class ProcessedData(
    val drugs: List<Drug>,
    val labs: List<Lab>
)

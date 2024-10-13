package com.hsb.task.test

import com.hsb.task.data.model.*
import org.junit.Test

class ApiResponseProcessorTest {

    @Test
    fun `processApiResponse should extract drugs and labs correctly`(): Unit {
        // Arrange
        val apiResponse = ApiResponse(
            problems = listOf(
                Problem(
                    Diabetes = listOf(
                        Diabetes(
                            medications = listOf(
                                Medication(
                                    medicationsClasses = listOf(
                                        MedicationClass(
                                            className = listOf(
                                                ClassNameGroup(
                                                    associatedDrug = listOf(
                                                        Drug(name = "Metformin", dose = "500mg", strength = "500mg", problemName = "Diabetes")
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            ),
                            labs = listOf(
                                Lab(name = "Blood Sugar", result = "Normal", problemName = "Diabetes")
                            )
                        )
                    ),
                    Asthma = listOf()
                )
            )
        )



    }
}

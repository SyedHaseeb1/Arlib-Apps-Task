package com.hsb.task.domain.repository

import com.hsb.task.data.model.ApiResponse
import com.hsb.task.data.model.Condition
import com.hsb.task.data.model.Drug
import com.hsb.task.data.model.ProcessedData
import com.hsb.task.data.model.Lab
import com.hsb.extensions_hsb.utils.globalextensions.Extensions.logIt

object ItemRepositoryImpl {
    fun processData(response: ApiResponse): ProcessedData {
        val drugList = mutableListOf<Drug>()
        val labList = mutableListOf<Lab>()

        response.problems.forEach { problem ->
            // Process each problem type
            problem.Diabetes.forEach { diabetes ->
                diabetes.logIt("Meds d")

                extractMedicationsAndLabs(diabetes, "Diabetes", drugList, labList)
            }

            problem.Asthma.forEach { asthma ->
                asthma.logIt("Meds a")
                extractMedicationsAndLabs(asthma, "Asthma", drugList, labList)
            }
        }

        return ProcessedData(drugs = drugList, labs = labList)
    }

    private fun extractMedicationsAndLabs(
        condition: Condition,
        problemName: String,
        drugList: MutableList<Drug>,
        labList: MutableList<Lab>
    ) {
        // Extract medications
        condition.medications.forEach { medication ->
            medication.medicationsClasses.forEach { medicationClass ->
                medicationClass.className.forEach { group ->
                    group.associatedDrug.forEach { drug ->
                        drugList.add(drug.copy(problemName = problemName))
                    }
                    group.associatedDrug2.forEach { drug ->
                        drugList.add(drug.copy(problemName = problemName))
                    }
                }
            }
        }
        // Extract labs
        condition.labs.forEach { lab ->
            labList.add(lab.copy(problemName = problemName)) // Set the problemName
        }
    }
}
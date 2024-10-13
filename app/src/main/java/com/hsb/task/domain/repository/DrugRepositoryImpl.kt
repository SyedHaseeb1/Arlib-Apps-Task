package com.hsb.task.domain.repository

import android.content.Context
import com.hsb.task.data.local.dao.DrugDao
import com.hsb.task.data.local.dao.LabDao
import com.hsb.task.data.model.DrugEntity
import com.hsb.task.data.model.LabEntity
import com.hsb.task.data.model.ProcessedData
import com.hsb.task.data.model.toDomainModel
import com.hsb.task.data.remote.ApiService
import com.hsb.task.domain.repository.ItemRepositoryImpl.processData
import com.hsb.extensions_hsb.utils.globalextensions.Extensions.isInternetAvailable
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DrugRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val drugDao: DrugDao,
    private val labDao: LabDao,
    @ApplicationContext private val context: Context
) : DrugRepository {
    override suspend fun getDrugs(): Result<ProcessedData> {
        return try {
            if (context.isInternetAvailable()) {
                // Fetch from API if no Room data
                val response = apiService.fetchDrugs()
                val combinedResponse = processData(response)

                // Save to Room
                drugDao.insertAll(combinedResponse.drugs.map {
                    DrugEntity(it.name, it.dose, it.strength, it.problemName)
                })
                combinedResponse.labs.mapNotNull { lab ->
                    lab.name?.let { name ->
                        lab.problemName?.let { problemName ->
                            LabEntity(name, lab.result, problemName)
                        }
                    }
                }.let { labEntities ->
                    labDao.insertAll(labEntities)
                }

                // Return API data
                Result.success(combinedResponse)
            } else {
                // First, try fetching from Room
                val storedDrugs = drugDao.getAllDrugs()
                val storedLabs = labDao.getAllLabs()
                if (storedDrugs.isNotEmpty()) {
                    // Return Room data if available
                    val processedData = ProcessedData(
                        drugs = storedDrugs.map { it.toDomainModel() },
                        labs = storedLabs.map { it.toDomainModel() }
                    )
                    Result.success(processedData)
                } else {
                    Result.failure(Throwable("No Internet Connection"))
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}

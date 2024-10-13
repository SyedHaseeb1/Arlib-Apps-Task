package com.hsb.task.domain.repository

import com.hsb.task.data.model.ProcessedData

interface DrugRepository {
    suspend fun getDrugs(): Result<ProcessedData>
}
package com.hsb.task.domain.usecase

import com.hsb.task.data.model.ProcessedData
import com.hsb.task.domain.repository.DrugRepository
import javax.inject.Inject

class GetDrugsUseCase @Inject constructor(
    private val repository: DrugRepository
) {
    suspend operator fun invoke(): Result<ProcessedData> {
        return repository.getDrugs()
    }
}

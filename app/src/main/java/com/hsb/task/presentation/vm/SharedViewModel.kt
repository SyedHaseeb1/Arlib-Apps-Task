package com.hsb.task.presentation.vm

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hsb.task.data.model.Drug
import com.hsb.task.data.model.ProcessedData
import com.hsb.task.domain.repository.DrugRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    application: Application,
    private val repository: DrugRepositoryImpl
) : AndroidViewModel(application) {
    var text = "default"
    var userName = mutableStateOf("")
    private val _drugsLiveData = MutableLiveData<Result<ProcessedData>>() // Shared Data
    val drugsLiveListData: LiveData<Result<ProcessedData>> get() = _drugsLiveData
    val drugsList = ArrayList<Drug>()
    fun setUsername(name: String) {
        userName.value = name
    }

    fun fetchDrugsFromApi() {
        viewModelScope.launch {
            _drugsLiveData.postValue(repository.getDrugs())
        }
    }

    fun getDrugDetails(drugName: String?): Drug? {
        return drugsList.find { it.name == drugName }
    }
}
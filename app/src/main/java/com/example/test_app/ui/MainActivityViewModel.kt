package com.example.test_app.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_app.repository.Repository
import com.example.test_app.api.ApiService
import com.example.test_app.models.Data
import com.example.test_app.models.DataEntity
import com.example.test_app.models.toDataEntity
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

class MainActivityViewModel(
    private val api : ApiService,
    private val repo : Repository
) : ViewModel() {

    val data: LiveData<List<DataEntity>> = repo.getAllData()

    fun loadData() {
        viewModelScope.launch {
            try {
                val result = api.getInfo()

                //В map превращай одну сущность в другую, более подходящую для записи в БД
                result.data.map { data ->
                    data.toDataEntity()
                }.forEach {
                    repo.addData(it)
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    fun saveChecked(item: DataEntity) {
        viewModelScope.launch {
            if (!item.isChecked) {
                repo.saveCheck(item.id_record)
            } else {
                repo.unselectSected(item.id_record)
            }
        }
    }
}



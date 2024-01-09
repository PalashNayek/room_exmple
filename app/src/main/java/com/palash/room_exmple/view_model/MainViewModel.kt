package com.palash.room_exmple.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.palash.room_exmple.models.MyDataClass
import com.palash.room_exmple.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val myRepository: MyRepository) : ViewModel() {

    //get record from repository
    fun recordList() = myRepository.getAllRecordList()

    fun insertNewRecordEmp(myDataClass: MyDataClass) = viewModelScope.launch {
        myRepository.insertNewRecord(myDataClass)
    }
}
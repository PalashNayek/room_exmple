package com.palash.room_exmple.repository

import com.palash.room_exmple.api_service.MyDao
import com.palash.room_exmple.models.MyDataClass
import javax.inject.Inject

class MyRepository @Inject constructor(private val myDao: MyDao) {

    //get list from database record
    fun getAllRecordList() = myDao.getAllRecordList()

    //insert new data
    suspend fun insertNewRecord(myDataClass: MyDataClass) = myDao.insertNewRecord(myDataClass)
}
package com.palash.room_exmple.api_service

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.palash.room_exmple.models.MyDataClass

@Dao
interface MyDao {
    @Insert
    suspend fun insertNewRecord(myDataClass: MyDataClass)

    @Query("SELECT * FROM emp")
    fun getAllRecordList() : LiveData<List<MyDataClass>>
}
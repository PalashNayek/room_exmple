package com.palash.room_exmple.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity("emp")
data class MyDataClass(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val address: String,
    val createdDate: Date,
    val isActive: Int

)

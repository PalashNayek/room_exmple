package com.palash.room_exmple.room_db

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    @TypeConverter
    fun fromDateToLong(value : Date) : Long{
        return value.time
    }

    @TypeConverter
    fun fromLogToDate(value : Long) : Date{
        return Date(value)
    }
}
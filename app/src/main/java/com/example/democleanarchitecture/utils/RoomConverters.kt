package com.example.democleanarchitecture.utils

import androidx.room.TypeConverter
import java.util.*

class RoomConverters {

    @TypeConverter
    fun fromDateToLong(mValue: Date): Long{
        return mValue.time
    }

    @TypeConverter
    fun fromLongToDate(mValue : Long) : Date{
        return Date(mValue)
    }

    @TypeConverter
    fun fromBooleanToInt(mvalue : Boolean) : Int{
        return if (mvalue) 1 else 0
    }

    @TypeConverter
    fun fromIntToBoolean(mValue : Int) : Boolean{
        return mValue == 1
    }
}
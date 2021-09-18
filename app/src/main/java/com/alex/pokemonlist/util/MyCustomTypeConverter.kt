package com.alex.pokemonlist.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class  MyCustomTypeConverter {
    private val gson = Gson()
    private val typeString: Type = object : TypeToken<List<String>>() {}.type
    @TypeConverter

    fun fromString(json: String?): List<String> {
        return gson.fromJson(json, typeString)
    }

    @TypeConverter
    fun fromList(list: List<String?>?): String {
        return gson.toJson(list, typeString)
    }
}

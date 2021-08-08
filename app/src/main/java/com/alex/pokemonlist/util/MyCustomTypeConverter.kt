package com.alex.pokemonlist.util

import androidx.room.TypeConverter
import com.alex.pokemonlist.domain.model.Family
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class  MyCustomTypeConverter {
    private val gson = Gson()
    private val typeString: Type = object : TypeToken<List<String>>() {}.type
    private val typeFamily: Type = object : TypeToken <Family>() {}.type
    @TypeConverter

    fun fromString(json: String?): List<String> {
        return gson.fromJson(json, typeString)
    }

    @TypeConverter
    fun fromList(list: List<String?>?): String {
        return gson.toJson(list, typeString)
    }
    @TypeConverter
    fun toFamily(family: Family?): String? {
        return if (family == null) null else gson.toJson(family,typeFamily)
    }
    @TypeConverter
    fun fromFamily(json: String?): Family? {
        return  gson.fromJson(json,typeFamily)
    }

}

package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.local.converters

import androidx.room.TypeConverter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.models.main_page.HotSaleLocalDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HotSalesConverter {

    @TypeConverter
    fun fromJson(hotSales: String): List<HotSaleLocalDto> {
        val type = object : TypeToken<List<HotSaleLocalDto>>() {}.type
        return Gson().fromJson(hotSales, type)
    }

    @TypeConverter
    fun toJson(hotSales: List<HotSaleLocalDto>): String {
        val type = object : TypeToken<List<HotSaleLocalDto>>() {}.type
        return Gson().toJson(hotSales, type)
    }
}
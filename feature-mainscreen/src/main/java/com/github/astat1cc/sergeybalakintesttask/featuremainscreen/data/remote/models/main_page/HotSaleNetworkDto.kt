package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.models.main_page

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.HotSale

data class HotSaleNetworkDto(
    val id: Int,
    val is_buy: Boolean,
    val is_new: Boolean,
    val picture: String,
    val subtitle: String,
    val title: String
) {

    fun mapToDomain() = HotSale(
        id = id,
        isBuy = is_buy,
        isNew = is_new,
        picture = picture,
        subtitle = subtitle,
        title = title
    )
}
package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.models.CartLocalDto.Companion.TABLE_NAME
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities.Cart

@Entity(tableName = TABLE_NAME)
data class CartLocalDto(
    val basket: List<BasketLocalDto>,
    val delivery: String,
    @PrimaryKey val id: String,
    val total: Int
) {

    fun mapToDomain() = Cart(
        basket = basket.map { it.mapToDomain() },
        delivery = delivery,
        id = id,
        total = total
    )

    companion object {

        fun fromDomain(cart: Cart) = with(cart) {
            CartLocalDto(
                basket.map { BasketLocalDto.fromDomain(it) },
                delivery,
                id,
                total
            )
        }

        const val TABLE_NAME = "cart_table"
    }
}
package com.silaeva.hotels_impl.domain.entity

data class Hotel(
    val id: Long,
    val name: String,
    val address: String,
    val minimalPrice: Long,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val imageUrls: List<String>,
    val aboutTheHotel: HotelDescription,
)

data class HotelDescription(
    val description: String,
    val peculiarities: List<String>,
)
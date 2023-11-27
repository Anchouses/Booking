package com.silaeva.hotels_impl.domain

import com.silaeva.hotels_impl.domain.entity.Hotel

interface HotelRepository {
    suspend fun getHotel(): Hotel
}
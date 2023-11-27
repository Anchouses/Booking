package com.silaeva.hotels_impl.data.retrofitApi

import com.silaeva.hotels_impl.domain.entity.Hotel
import retrofit2.http.GET

interface HotelApi {
    @GET("v3/d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotelInfo(): Hotel
}
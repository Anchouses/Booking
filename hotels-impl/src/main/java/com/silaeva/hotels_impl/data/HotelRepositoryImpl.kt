package com.silaeva.hotels_impl.data

import com.silaeva.hotels_impl.data.retrofitApi.HotelApi
import com.silaeva.hotels_impl.domain.HotelRepository
import com.silaeva.hotels_impl.domain.entity.Hotel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HotelRepositoryImpl: HotelRepository {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: HotelApi = retrofit.create(HotelApi::class.java)

    override suspend fun getHotel(): Hotel {
        return api.getHotelInfo()
    }


}
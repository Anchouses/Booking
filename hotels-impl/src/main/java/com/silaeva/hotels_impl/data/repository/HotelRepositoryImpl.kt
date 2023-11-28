package com.silaeva.hotels_impl.data.repository

import com.silaeva.hotels_impl.data.retrofitApi.HotelApi
import com.silaeva.hotels_impl.domain.HotelRepository
import com.silaeva.hotels_impl.domain.entity.Hotel
import com.silaeva.hotels_impl.domain.entity.HotelDescription
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HotelRepositoryImpl: HotelRepository {

    private val interceptor = HttpLoggingInterceptor()

    init { interceptor.level = HttpLoggingInterceptor.Level.BODY }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: HotelApi = retrofit.create(HotelApi::class.java)

    override suspend fun getHotel(): Hotel {
        val resul: Hotel = api.getHotelInfo().let { hotelModel ->
            Hotel(
                about_the_hotel = hotelModel.about_the_hotel.let {
                    HotelDescription(description = it.description, peculiarities = it.peculiarities)
                                                                 },
                adress = hotelModel.adress,
                id = hotelModel.id,
                image_urls = hotelModel.image_urls,
                minimal_price = hotelModel.minimal_price,
                name = hotelModel.name,
                price_for_it = hotelModel.price_for_it,
                rating_name = hotelModel.rating_name,
                rating = hotelModel.rating)
        }
        return resul
    }
}
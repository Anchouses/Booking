package com.silaeva.hotels_impl.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silaeva.hotels_impl.data.HotelRepositoryImpl
import com.silaeva.hotels_impl.domain.entity.Hotel
import com.silaeva.hotels_impl.domain.entity.HotelDescription
import com.silaeva.rooms_api.RoomsCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val roomsCoordinator: RoomsCoordinator
): ViewModel() {

    private val _hotel = MutableStateFlow(
        Hotel(
            id = 1,
            name = "Лучший пятизвездочный отель в Хургаде, Египет",
            address = "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
            minimalPrice = 134268,
            priceForIt = "За тур с перелётом",
            rating = 5,
            ratingName = "Превосходно",
            imageUrls = listOf(
                "https://www.atorus.ru/sites/default/files/upload/image/News/56149/Club_Priv%C3%A9_by_Belek_Club_House.jpg",
                "https://deluxe.voyage/useruploads/articles/The_Makadi_Spa_Hotel_02.jpg",
                "https://deluxe.voyage/useruploads/articles/article_1eb0a64d00.jpg"
            ),
            aboutTheHotel = HotelDescription(
                description = "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
                peculiarities = listOf(
                    "Бесплатный Wifi на всей территории отеля",
                    "1 км до пляжа",
                    "Бесплатный фитнес-клуб",
                    "20 км до аэропорта"
                )
            )
        )
    )

    val hotel : StateFlow < Hotel > = _hotel

    private var requestJob: Job? = null

    fun getHotel() {
        requestJob?.cancel()
        requestJob = viewModelScope.launch {
            _hotel.value = HotelRepositoryImpl().getHotel()
        }
    }

    fun onChooseRoomButtonClick(hotelName: String) {
        roomsCoordinator.navigateToRooms(hotelName)
    }

}


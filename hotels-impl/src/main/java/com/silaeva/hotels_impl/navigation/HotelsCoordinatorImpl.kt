package com.silaeva.hotels_impl.navigation

import com.github.terrakok.cicerone.Router
import com.silaeva.hotel_api.HotelsCoordinator
import javax.inject.Inject

class HotelsCoordinatorImpl @Inject constructor(
    private val router: Router
): HotelsCoordinator {
    override fun navigateToHotel() {
        router.navigateTo(HotelScreen())
    }
}
package com.silaeva.rooms_impl.navigation

import com.github.terrakok.cicerone.Router
import com.silaeva.rooms_api.RoomsCoordinator
import javax.inject.Inject

class RoomsCoordinatorImpl @Inject constructor(
    private val router: Router
): RoomsCoordinator {
    override fun navigateToRooms() {
        router.navigateTo(RoomsScreen())
    }
}
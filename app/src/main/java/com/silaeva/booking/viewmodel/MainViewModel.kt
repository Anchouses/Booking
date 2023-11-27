package com.silaeva.booking.viewmodel

import androidx.lifecycle.ViewModel
import com.silaeva.hotel_api.HotelsCoordinator
import com.silaeva.rooms_api.RoomsCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val hotelsCoordinator: HotelsCoordinator,
    private val roomsCoordinator: RoomsCoordinator
): ViewModel() {

    fun onCreated() {
        hotelsCoordinator.navigateToHotel()
    }
}
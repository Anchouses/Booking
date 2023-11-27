package com.silaeva.booking.di

import com.silaeva.rooms_api.RoomsCoordinator
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@EntryPoint
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface RoomsModuleDependencies {

  fun roomsCoordinator(): RoomsCoordinator
}
package com.silaeva.booking.di

import com.silaeva.hotel_api.HotelsCoordinator
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@EntryPoint
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface HotelsModuleDependencies {

  fun hotelsCoordinator(): HotelsCoordinator
}
package com.silaeva.hotels_impl.di

import com.silaeva.hotel_api.HotelsCoordinator
import com.silaeva.hotels_impl.navigation.HotelsCoordinatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
interface HotelsModule {

    @Binds
    fun hotelsCoordinator(impl: HotelsCoordinatorImpl): HotelsCoordinator
}
package com.silaeva.rooms_impl.di

import com.silaeva.rooms_api.RoomsCoordinator
import com.silaeva.rooms_impl.navigation.RoomsCoordinatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RoomsModule {

    @Binds
    fun roomsCoordinator(impl: RoomsCoordinatorImpl): RoomsCoordinator
}
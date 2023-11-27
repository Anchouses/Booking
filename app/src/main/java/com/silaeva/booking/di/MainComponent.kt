package com.silaeva.booking.di

import com.silaeva.hotels_impl.di.HotelsModule
import com.silaeva.rooms_impl.di.RoomsModule
import dagger.Component

@Component(
    dependencies = [HotelsModuleDependencies::class, RoomsModuleDependencies::class],
    modules = [HotelsModule::class, RoomsModule::class]
)
interface MainComponent
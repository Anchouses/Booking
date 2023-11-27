package com.silaeva.hotels_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.silaeva.hotels_impl.presentation.HotelFragment

class HotelScreen() : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        HotelFragment.newInstance()

}
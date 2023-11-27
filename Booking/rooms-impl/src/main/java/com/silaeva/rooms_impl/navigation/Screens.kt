package com.silaeva.rooms_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.silaeva.rooms_impl.RoomsFragment

class RoomsScreen() : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        RoomsFragment.newInstance()
}
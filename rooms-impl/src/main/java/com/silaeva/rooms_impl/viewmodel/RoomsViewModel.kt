package com.silaeva.rooms_impl.viewmodel

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val router: Router
): ViewModel() {

    private val _hotelName = MutableStateFlow("")
    val hotelName: StateFlow<String>
        get() = _hotelName

    fun onBackButtonClick() {
        router.exit()
    }

    fun init(hotelName: String) {
        _hotelName.value = hotelName
    }
}
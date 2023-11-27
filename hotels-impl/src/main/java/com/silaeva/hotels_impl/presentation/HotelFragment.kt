package com.silaeva.hotels_impl.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.silaeva.hotels_impl.databinding.FragmentHotelBinding
import com.silaeva.hotels_impl.presentation.ui.HotelScreen
import com.silaeva.hotels_impl.presentation.viewmodel.HotelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotelFragment : Fragment() {

    private lateinit var binding: FragmentHotelBinding

    private val viewModel: HotelViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHotelBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setContent {
            MaterialTheme {
                HotelScreen(viewModel)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = HotelFragment()
    }
}
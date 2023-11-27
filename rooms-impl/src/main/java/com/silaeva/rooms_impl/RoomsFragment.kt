package com.silaeva.rooms_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.silaeva.rooms_impl.databinding.FragmentRoomsBinding
import com.silaeva.rooms_impl.ui.RoomsScreen
import com.silaeva.rooms_impl.viewmodel.RoomsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private lateinit var binding: FragmentRoomsBinding

    private val viewModel: RoomsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRoomsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(requireArguments().getString(HOTEL_NAME_KEY).orEmpty())
        binding.root.setContent {
            RoomsScreen(viewModel)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(hotelName: String) = RoomsFragment().apply {
            arguments = bundleOf(HOTEL_NAME_KEY to hotelName)
        }

        private val HOTEL_NAME_KEY = "HOTEL_NAME_KEY"
    }
}
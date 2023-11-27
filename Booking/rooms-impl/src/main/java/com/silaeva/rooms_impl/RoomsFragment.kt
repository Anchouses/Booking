package com.silaeva.rooms_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.silaeva.rooms_impl.databinding.FragmentRoomsBinding
import com.silaeva.rooms_impl.ui.RoomsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private lateinit var binding: FragmentRoomsBinding

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
        binding.root.setContent {
            RoomsScreen()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = RoomsFragment()
    }
}
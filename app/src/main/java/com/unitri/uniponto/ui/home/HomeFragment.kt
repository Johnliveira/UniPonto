package com.unitri.uniponto.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.unitri.uniponto.databinding.FragmentHomeBinding
import com.unitri.uniponto.util.Clock

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val clock = Clock()
        val hour: TextView = binding.clockHour
        val minute: TextView = binding.clockMinute

        homeViewModel.text.observe(viewLifecycleOwner) {
            hour.text = clock.getHour()
            minute.text = clock.getMinute()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
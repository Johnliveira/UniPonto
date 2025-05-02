package com.unitri.uniponto.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.unitri.uniponto.databinding.FragmentHomeBinding
import com.unitri.uniponto.util.Clock
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var clickCount = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val clock = Clock()
        val hour = binding.clockHour
        val minute = binding.clockMinute

        homeViewModel.text.observe(viewLifecycleOwner) {
            hour.text = clock.getHour()
            minute.text = clock.getMinute()
        }

        setupRegisterButton()
        return binding.root
    }

    private fun setupRegisterButton() {
        binding.registerButton.setOnClickListener {
            val currentTime = getCurrentTime()

            when (clickCount) {
                0 -> {
                    binding.entryTime.text = currentTime
                    binding.entryTime.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Entrada registrada", Toast.LENGTH_SHORT).show()
                }
                1 -> {
                    binding.goLunchTime.text = currentTime
                    binding.goLunchTime.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Saída para almoço registrada", Toast.LENGTH_SHORT).show()
                }
                2 -> {
                    binding.returnLunchTime.text = currentTime
                    binding.returnLunchTime.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Retorno do almoço registrado", Toast.LENGTH_SHORT).show()
                }
                3 -> {
                    binding.exitTime.text = currentTime
                    binding.exitTime.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Saída registrada", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(requireContext(), "Todos os registros já foram feitos", Toast.LENGTH_LONG).show()
                }
            }

            if (clickCount < 4) {
                clickCount++
            }
        }
    }

    private fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        return formatter.format(Date())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

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
import com.unitri.uniponto.util.RegisterOrder
import com.unitri.uniponto.util.RegisterTime
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var clickCount = 0
    private var registerTimes = ArrayList<RegisterTime>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val hour = binding.clockHour
        val minute = binding.clockMinute

        val clock = Clock()
        homeViewModel.text.observe(viewLifecycleOwner) {
            hour.text = clock.getHour()
            minute.text = clock.getMinute()
        }

        if (registerTimes.isNotEmpty()) {
            registerTimes.forEach(::setRegisterTImesVisibility)
        }

        setupRegisterButton()
        return binding.root
    }

    private fun setupRegisterButton() {
        binding.registerButton.setOnClickListener {
            val currentTime = getCurrentTime()

            when (clickCount) {
                0 -> {
                    registerTimes.add(RegisterTime(RegisterOrder.ENTRY, currentTime))
                    binding.entryTime.text = currentTime
                    binding.entryTime.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Entrada registrada", Toast.LENGTH_SHORT)
                        .show()
                }

                1 -> {
                    registerTimes.add(RegisterTime(RegisterOrder.GO_LUNCH, currentTime))
                    binding.goLunchTime.text = currentTime
                    binding.goLunchTime.visibility = View.VISIBLE
                    Toast.makeText(
                        requireContext(),
                        "Saída para almoço registrada",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                2 -> {
                    registerTimes.add(RegisterTime(RegisterOrder.BACK_LUNCH, currentTime))
                    binding.backLunchTime.text = currentTime
                    binding.backLunchTime.visibility = View.VISIBLE
                    Toast.makeText(
                        requireContext(),
                        "Retorno do almoço registrado",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                3 -> {
                    registerTimes.add(RegisterTime(RegisterOrder.EXIT, currentTime))
                    binding.exitTime.text = currentTime
                    binding.exitTime.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "Saída registrada", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Toast.makeText(
                        requireContext(),
                        "Todos os registros já foram feitos",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            if (clickCount < 4) {
                clickCount++
            }
        }
    }

    private fun setRegisterTImesVisibility(registerTime: RegisterTime) {
        val order = registerTime.order

        when (order) {
            RegisterOrder.ENTRY -> {
                binding.entryTime.visibility = View.VISIBLE
                binding.entryTime.text = registerTime.value
            }

            RegisterOrder.GO_LUNCH -> {
                binding.goLunchTime.visibility = View.VISIBLE
                binding.goLunchTime.text = registerTime.value
            }

            RegisterOrder.BACK_LUNCH -> {
                binding.backLunchTime.visibility = View.VISIBLE
                binding.backLunchTime.text = registerTime.value
            }

            RegisterOrder.EXIT -> {
                binding.exitTime.visibility = View.VISIBLE
                binding.exitTime.text = registerTime.value
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

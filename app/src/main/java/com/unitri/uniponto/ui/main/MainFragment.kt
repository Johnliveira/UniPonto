package com.unitri.uniponto.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.unitri.uniponto.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentManager = childFragmentManager
        val navHostFragment = NavHostFragment.create(R.navigation.mobile_navigation)
        fragmentManager.beginTransaction()
            .replace(R.id.nav_host_main, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commitNow()

        val navController = navHostFragment.navController
        val bottomNav = view.findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNav.setupWithNavController(navController)
    }

}

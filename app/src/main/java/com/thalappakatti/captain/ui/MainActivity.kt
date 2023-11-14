/*
 * Created by Nethaji V on 31/01/22, 3:19 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 3:19 PM
 */

package com.thalappakatti.captain.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.thalappakatti.captain.R
import com.thalappakatti.captain.data.viewmodel.LoginViewModel
import com.thalappakatti.captain.databinding.ActivityMainBinding
import com.thalappakatti.captain.di.blockInput
import com.thalappakatti.captain.di.unblockInput
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout

        viewModel.navigateToLogin.observe(this, {
            navController.navigate(R.id.action_global_loginFragment)
        })

      //  binding.navView.h

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

//        val navController = findNavController(R.id.navHostFragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragmentOrderNow, R.id.fragmentUnSuccessfulOrder, R.id.fragmentSyncMenu
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            binding.appBarMain.toolbar.visibility = View.VISIBLE
            when (destination.id) {
                R.id.splashFragment -> binding.appBarMain.toolbar.visibility = View.GONE
                R.id.loginFragment -> binding.appBarMain.toolbar.visibility = View.GONE
                R.id.logout -> {
                    navController.navigate(R.id.action_global_loginFragment)
                }
                else -> binding.appBarMain.toolbar.visibility = View.VISIBLE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id != null) {
            when (navController.currentDestination?.id) {
                R.id.splashFragment, R.id.loginFragment, R.id.fragmentOrderNow, R.id.fragmentUnSuccessfulOrder, R.id.fragmentSyncMenu -> finish()
                else -> navController.navigateUp()
            }
        } else
            super.onBackPressed()
    }

    fun blockInput() {
        blockInput(binding.appBarMain.ilContainer.progressBar)
    }

    fun unblockInput() {
        unblockInput(binding.appBarMain.ilContainer.progressBar)
    }

}
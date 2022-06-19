package com.example.pd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pd.databinding.MainActivityBinding

// TODO: Сделать так, чтобы настройки профиля подгружались на HomeFragment и добавлялись в БД
class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        
        navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.profileFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)
        
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNav()
                R.id.searchFragment -> showBottomNav()
                R.id.profileFragment -> showBottomNav()
                else -> goneBottomNav()
            }
        }
    }
    
    private fun showBottomNav() {
        binding.bottomNavigationView.isGone = false
    }
    
    private fun goneBottomNav() {
        binding.bottomNavigationView.isGone = true
    }
    
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }
}
package com.example.shopkart.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.shopkart.R
import com.example.shopkart.databinding.ActivityExerciseBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_exercise)
        val bottomNavigation = binding.bottomNavigationExercise

//      navigationWithFragmentManager(bottomNavigation) // This function is used for switching fragments using fragment manager
        navigationWithNavComponent(bottomNavigation)
    }

    private fun navigationWithNavComponent(bottomNavigation: BottomNavigationView) {
        binding.apply {
            bottomNavigation.setupWithNavController(navController)
        }
    }

    private fun navigationWithFragmentManager(bottomNavigation: BottomNavigationView) {
        binding.apply {
            bottomNavigation.setOnItemSelectedListener { item ->
                val fragment: Fragment
                when (item.itemId) {
                    R.id.galleryFragment -> {
                        fragment = GalleryFragment()
                        loadFragment(fragment)
                        true
                    }

                    R.id.addMessageFragment -> {
                        fragment = AddMessageFragment()
                        loadFragment(fragment)
                        true
                    }

                    R.id.viewMessageFragment -> {
                        fragment = ViewMessageFragment()
                        loadFragment(fragment)
                        true
                    }

                    else -> {
                        false
                    }
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.navHostFragment, fragment)
        }
    }
}
package com.danieer.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.danieer.newsapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        setupBottomNavBar(binding.bottomMainNavBar)
    }

    private fun setupBottomNavBar(bottomNavigationView: BottomNavigationView) {
        bottomNavigationView.apply {
            setOnItemSelectedListener {
                handleSectionClicked(it)
                true
            }
        }
    }

    private fun handleSectionClicked(sectionItem: MenuItem) {

    }
}
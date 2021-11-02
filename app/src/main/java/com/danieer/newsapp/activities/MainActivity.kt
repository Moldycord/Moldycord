package com.danieer.newsapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.danieer.newsapp.R
import com.danieer.newsapp.databinding.ActivityMainBinding
import com.danieer.newsapp.fragments.EntertainmentSectionFragment
import com.danieer.newsapp.fragments.HomeFragment
import com.danieer.newsapp.fragments.SportsSectionFragment
import com.danieer.newsapp.fragments.TechSectionFragment
import com.danieer.newsapp.utils.ENTERTAINMENT_SECTION
import com.danieer.newsapp.utils.HOME_SECTION
import com.danieer.newsapp.utils.SPORTS_SECTION
import com.danieer.newsapp.utils.TECH_SECTION
import com.google.android.material.bottomnavigation.BottomNavigationView

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
            selectedItemId = R.id.home_section
        }
    }

    private fun handleSectionClicked(sectionItem: MenuItem) {
        when (sectionItem.itemId) {
            R.id.home_section -> showFragmentByTag(HOME_SECTION)
            R.id.sports_section -> showFragmentByTag(SPORTS_SECTION)
            R.id.entmt_section -> showFragmentByTag(ENTERTAINMENT_SECTION)
            R.id.tech_section -> showFragmentByTag(TECH_SECTION)
            else -> Unit
        }
    }

    private fun showFragmentByTag(tag: String) {
        val fragment = supportFragmentManager.findFragmentByTag(tag)
        fragment?.let {
            replaceFragment(tag, it)
        } ?: replaceFragment(tag, getFragmentInstanceByTag(tag))
    }

    private fun getFragmentInstanceByTag(tag: String): Fragment {
        return when (tag) {
            HOME_SECTION -> HomeFragment.newInstance()
            TECH_SECTION -> TechSectionFragment.newInstance()
            ENTERTAINMENT_SECTION -> EntertainmentSectionFragment.newInstance()
            SPORTS_SECTION -> SportsSectionFragment.newInstance()
            else -> HomeFragment.newInstance()
        }
    }

    private fun replaceFragment(tag: String, fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment, tag)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
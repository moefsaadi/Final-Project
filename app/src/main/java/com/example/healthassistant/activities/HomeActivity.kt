package com.example.healthassistant.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healthassistant.R
import com.example.healthassistant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.alarm_menu ->
                {
                    //TODO: Navigate to Alarm Page
                    true
                }
                R.id.home_menu ->
                {
                    //TODO: Navigate to Home Page
                    true
                }
                R.id.settings_menu ->
                {
                    //TODO: Navigate to Settings Page
                    true
                }
                else -> false

            }

        }
    }
}
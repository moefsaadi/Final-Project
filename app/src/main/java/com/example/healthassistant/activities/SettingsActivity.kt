package com.example.healthassistant.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.healthassistant.R
import com.example.healthassistant.databinding.ActivityAlarmBinding
import com.example.healthassistant.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Set Settings Icon as selected
        binding.bottomNavBar.selectedItemId = R.id.settings_menu


        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.alarm_menu ->
                {
                    val intent = Intent(this, AlarmActivity::class.java)
                    overridePendingTransition(0,0)
                    startActivity(intent)


                    true
                }
                R.id.home_menu ->
                {
                    val intent = Intent(this, HomeActivity::class.java)
                    overridePendingTransition(0,0)
                    startActivity(intent)

                    true
                }
                R.id.settings_menu ->
                {

                    true
                }
                else -> false
            }
        }



    }

}
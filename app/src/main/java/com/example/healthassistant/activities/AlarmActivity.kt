package com.example.healthassistant.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.healthassistant.R
import com.example.healthassistant.databinding.ActivityAlarmBinding
import com.google.android.material.snackbar.Snackbar

class AlarmActivity : AppCompatActivity() {

private lateinit var binding: ActivityAlarmBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Set Alarm Icon as selected
        binding.bottomNavBar.selectedItemId = R.id.alarm_menu

        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.alarm_menu ->
                {
                    Snackbar.make(binding.root,"Switched to Alarm Page",Snackbar.LENGTH_INDEFINITE).show()

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

                    val intent = Intent(this, SettingsActivity::class.java)
                    overridePendingTransition(0,0)
                    startActivity(intent)


                    true
                }
                else -> false
            }
        }

    }
}
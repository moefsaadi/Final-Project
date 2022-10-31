package com.example.healthassistant.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
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

        var isOpen = false
        val fabOpenAnim: Animation = AnimationUtils.loadAnimation(this,R.anim.fab_open)
        val fabCloseAnim: Animation = AnimationUtils.loadAnimation(this,R.anim.fab_close)

        binding.fabMain.setOnClickListener{
            if(isOpen){

                binding.fabAppt.startAnimation(fabCloseAnim)
                binding.fabMed.startAnimation(fabCloseAnim)
                binding.tvAppt.visibility = View.INVISIBLE
                binding.tvMed.visibility = View.INVISIBLE

                isOpen = false
            } else {


                binding.fabAppt.startAnimation(fabOpenAnim)
                binding.fabMed.startAnimation(fabOpenAnim)
                binding.tvAppt.visibility = View.VISIBLE
                binding.tvMed.visibility = View.VISIBLE

                isOpen = true
            }
        }

        binding.fabMed.setOnClickListener{
            //TODO: Write instructions
        }

        binding.fabAppt.setOnClickListener{
            //TODO: Write instructions
        }
    }
}
package com.example.healthassistant.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.healthassistant.R
import com.example.healthassistant.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.alarm_menu ->
                {
                    //TODO: Navigate to Alarm Page

                    snackbarCreate("Switched To Alarm Page","Dismiss")

                    true
                }
                R.id.home_menu ->
                {
                    snackbarCreate("Switched To Home Page","Dismiss")

                    //TODO: Navigate to Home Page
                    true
                }
                R.id.settings_menu ->
                {
                    snackbarCreate("Switched To Settings Page","Dismiss")

                    //TODO: Navigate to Settings Page
                    true
                }
                else -> false
            }
        }


        binding.fabMain.setOnClickListener{
            animateFab()
        }

        binding.fabMed.setOnClickListener{
            //TODO: Write instructions
        }

        binding.fabAppt.setOnClickListener{
            //TODO: Write instructions
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val lightTxt = "Switching to Light Theme!"
        val darkTxt = "Switching to Dark Theme!"

        when(item.itemId){
            R.id.light_theme_menu ->
            {
                snackbarCreate("Switched To Light Mode","Dismiss")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            R.id.dark_theme_menu ->
            {
                snackbarCreate("Switched To Dark Mode","Dismiss")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

        return true
    }




    private fun snackbarCreate(message: String, action: String)
    {
        val snackbar = Snackbar.make(binding.snackbarLayout,message,Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction(action){
            //Dismiss
        }
        snackbar.anchorView = binding.fabMain
        snackbar.show()
    }

    private fun animateFab()
    {
        val fabOpenAnim: Animation = AnimationUtils.loadAnimation(this,R.anim.fab_open)
        val fabCloseAnim: Animation = AnimationUtils.loadAnimation(this,R.anim.fab_close)
        val rotateForward: Animation = AnimationUtils.loadAnimation(this,R.anim.rotate_forward)
        val rotateBackward: Animation = AnimationUtils.loadAnimation(this,R.anim.rotate_backward)

        if(isOpen){

            binding.fabMain.startAnimation(rotateBackward)
            binding.fabAppt.startAnimation(fabCloseAnim)
            binding.fabMed.startAnimation(fabCloseAnim)
            binding.tvAppt.startAnimation(fabCloseAnim)
            binding.tvMed.startAnimation(fabCloseAnim)

            isOpen = false
        } else {
            binding.fabMain.startAnimation(rotateForward)
            binding.fabAppt.startAnimation(fabOpenAnim)
            binding.fabMed.startAnimation(fabOpenAnim)
            binding.tvAppt.startAnimation(fabOpenAnim)
            binding.tvMed.startAnimation(fabOpenAnim)

            isOpen = true
        }

    }
}
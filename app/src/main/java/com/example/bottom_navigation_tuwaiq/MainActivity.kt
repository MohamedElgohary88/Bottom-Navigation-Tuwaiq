package com.example.bottom_navigation_tuwaiq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationClicks()
    }

    private fun bottomNavigationClicks() {
        bottomnavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{

                chooseFragment(HomeFragment(),"Home")
                supportActionBar?.title = "Home" }

                R.id.person -> {
                chooseFragment(ProfileFragment(),"Profile")
                supportActionBar?.title = "Profile" }

                R.id.settings -> {
                chooseFragment(SettingsFragment(),"Settings")
                supportActionBar?.title = "Settings" }

                R.id.notifications -> {
                chooseFragment(NotificationsFragment(),"Notifications")
                supportActionBar?.title = "Notifications" }
            }
            true
        }
    }

    private fun chooseFragment(fragment:Fragment,tag:String) {
       val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout,fragment,tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }

}
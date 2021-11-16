package com.olesya.fragmentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECT_ITEM = "item"

class MainActivity : AppCompatActivity() {

    private lateinit var buttomMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttomMenu = findViewById(R.id.buttom_menu)

        buttomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu -> {
                    val menuFragment = MenuFragment()
                    replaceFragment(menuFragment)
                }
                R.id.about -> {
                    val aboutFragment = AboutFragment()
                    replaceFragment(aboutFragment)
                }
            }



            true
        }

        buttomMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECT_ITEM) ?: R.id.menu
        //buttomMenu.selectedItemId = if(savedInstanceState == null)R.id.menu else savedInstanceState.getInt(
        //    LAST_SELECT_ITEM)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECT_ITEM, buttomMenu.selectedItemId)
        super.onSaveInstanceState(outState)

    }
}
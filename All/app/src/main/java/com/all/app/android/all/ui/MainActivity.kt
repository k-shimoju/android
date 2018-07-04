package com.all.app.android.all.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.all.app.android.all.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {//, HasSupportFragmentInjector {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setupWithNavController(Navigation.findNavController(this, R.id.main_contents))
        navigation.setOnNavigationItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(this, R.id.main_contents))
        }
    }
}

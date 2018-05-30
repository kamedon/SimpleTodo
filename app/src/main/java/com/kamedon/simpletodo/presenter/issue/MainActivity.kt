package com.kamedon.simpletodo.presenter.issue

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.kamedon.simpletodo.R
import com.kamedon.simpletodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(this, R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
    }
}

package com.assessment.seloger.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assessment.seloger.R
import com.assessment.seloger.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().also {
            it.add(R.id.parentContainer, HomeFragment()).commit()
        }
    }
}
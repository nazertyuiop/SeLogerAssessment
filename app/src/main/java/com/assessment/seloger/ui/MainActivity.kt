package com.assessment.seloger.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assessment.seloger.R
import com.assessment.seloger.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.parentContainer, HomeFragment()).commit()
    }
}
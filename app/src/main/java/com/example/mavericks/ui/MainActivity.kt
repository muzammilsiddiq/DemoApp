package com.example.mavericks.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mavericks.R

class CounterActivity : AppCompatActivity(R.layout.counter_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.lyt, HomeFragment()).commit()
    }
}
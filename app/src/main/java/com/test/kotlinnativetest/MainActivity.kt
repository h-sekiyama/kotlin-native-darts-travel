package com.test.kotlinnativetest

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import createApplicationScreenMessage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.main_text).text = createApplicationScreenMessage()
    }
}
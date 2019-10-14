package com.test.kotlinnativetest

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.serialization.ImplicitReflectionSerializer
import sequentialRequests
class MainActivity : AppCompatActivity() {
    @ImplicitReflectionSerializer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            findViewById<TextView>(R.id.main_text).text = sequentialRequests()
        }
    }
}
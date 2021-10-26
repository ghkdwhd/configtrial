package com.example.configtrial

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 레이아웃
        setContentView(R.layout.activity_main)

        // 로그
        Log.d(TAG, "MainActivity - onCreate() called")
    }
}

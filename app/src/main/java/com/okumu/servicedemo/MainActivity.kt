package com.okumu.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.okumu.servicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceIntent = Intent(this, MyBackgroundService::class.java)

        serviceIntent.putExtra(MyBackgroundService.NAME, "Alex")
        serviceIntent.putExtra(MyBackgroundService.MARKS, 78)

        //start button
        binding.btnStart.setOnClickListener{
            Log.i(MyBackgroundService.TAG, "Starting Service")
            startService(serviceIntent)
            Toast.makeText(this, "Start button clicked", Toast.LENGTH_SHORT).show()
        }

        //stop button
        binding.btnStop.setOnClickListener{
            Log.i(MyBackgroundService.TAG, "Stopping Service")
            stopService(serviceIntent)
            Toast.makeText(this, "Stop button clicked", Toast.LENGTH_SHORT).show()
        }


    }
}
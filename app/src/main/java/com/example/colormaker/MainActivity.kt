package com.example.colormaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    private lateinit var redSwitch: SwitchCompat
    private lateinit var redSeek: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redSwitch = findViewById(R.id.redSwitch)
        redSeek = findViewById(R.id.redSeekBar)

        redSeek.isEnabled = redSwitch.isChecked

        redSwitch.setOnCheckedChangeListener { _, _ ->
            redSeek.isEnabled = redSwitch.isChecked
        }
    }
}
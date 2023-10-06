package com.example.colormaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    private lateinit var screen: View
    private lateinit var redSwitch: SwitchCompat
    private lateinit var redSeek: SeekBar
    private lateinit var redNum: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screen = findViewById(R.id.view)
        redSwitch = findViewById(R.id.redSwitch)
        redSeek = findViewById(R.id.redSeekBar)
        redNum = findViewById(R.id.redDecimalValue)

        var red: Float = 0.5F
        redNum.setText(red.toString())
        redSeek.progress = (red * 100).toInt()

        redSeek.isEnabled = redSwitch.isChecked
        redNum.isEnabled = redSwitch.isChecked

        redSwitch.setOnCheckedChangeListener { _, _ ->
            redSeek.isEnabled = redSwitch.isChecked
            redNum.isEnabled = redSwitch.isChecked
        }

        redNum.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                red = redNum.text.toString().toFloat()
                redSeek.progress = (red * 100).toInt()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {            }

            override fun afterTextChanged(s: Editable?) {            }
        })

        redSeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(redSeek: SeekBar, progress: Int, fromUser: Boolean) {
                red = redSeek.progress / 100.0F
                redNum.setText(red.toString())
            }

            override fun onStartTrackingTouch(redSeek: SeekBar) {            }

            override fun onStopTrackingTouch(redSeek: SeekBar) {
                Toast.makeText(this@MainActivity, "Progress is: " + redSeek.progress, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
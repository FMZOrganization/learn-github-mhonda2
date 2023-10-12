package com.example.colormaker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    // variable initialization
    private lateinit var screen: View
    private lateinit var redSwitch: Switch
    private lateinit var greenSwitch: Switch
    private lateinit var blueSwitch: Switch
    private lateinit var redSeek: SeekBar
    private lateinit var greenSeek: SeekBar
    private lateinit var blueSeek: SeekBar
    private lateinit var redNum: EditText
    private lateinit var greenNum: EditText
    private lateinit var blueNum: EditText
    private lateinit var reset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // variables linked with views
        screen = findViewById(R.id.colorBox)
        redSwitch = findViewById(R.id.redSwitch)
        greenSwitch = findViewById(R.id.greenSwitch)
        blueSwitch = findViewById(R.id.blueSwitch)
        redSeek = findViewById(R.id.redSeekBar)
        greenSeek = findViewById(R.id.greenSeekBar)
        blueSeek = findViewById(R.id.blueSeekBar)
        redNum = findViewById(R.id.redDecimalValue)
        greenNum = findViewById(R.id.greenDecimalValue)
        blueNum = findViewById(R.id.blueDecimalValue)
        reset = findViewById(R.id.resetButton)

        // starting point for red value
        var red: Float = 0.5F
        var redTemp: Float = red
        redNum.setText(red.toString())
        redSeek.progress = (red * 100).toInt()

        // starting point for green value
        var green: Float = 0.8F
        var greenTemp: Float = green
        greenNum.setText(green.toString())
        greenSeek.progress = (green * 100).toInt()

        // starting point for blue value
        var blue: Float = 0.3F
        var blueTemp: Float = blue
        blueNum.setText(blue.toString())
        blueSeek.progress = (blue * 100).toInt()

        // starting point for views
        redSeek.isEnabled = redSwitch.isChecked
        redNum.isEnabled = redSwitch.isChecked
        greenSeek.isEnabled = greenSwitch.isChecked
        greenNum.isEnabled = greenSwitch.isChecked
        blueSeek.isEnabled = blueSwitch.isChecked
        blueNum.isEnabled = blueSwitch.isChecked

        // starting point for color box
        screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))

        // Red Switch Listener
        redSwitch.setOnCheckedChangeListener { _, _ ->
            redSeek.isEnabled = redSwitch.isChecked
            redNum.isEnabled = redSwitch.isChecked
            if (!redSwitch.isChecked) {
                redTemp = red
                red = 0.0F
            }
            else {
                red = redTemp
            }
            screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
        }

        // Green Switch Listener
        greenSwitch.setOnCheckedChangeListener { _, _ ->
            greenSeek.isEnabled = greenSwitch.isChecked
            greenNum.isEnabled = greenSwitch.isChecked
            if (!greenSwitch.isChecked) {
                greenTemp = green
                green = 0.0F
            }
            else {
                green = greenTemp
            }
            screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
        }

        // Blue Switch Listener
        blueSwitch.setOnCheckedChangeListener { _, _ ->
            blueSeek.isEnabled = blueSwitch.isChecked
            blueNum.isEnabled = blueSwitch.isChecked
            if (!blueSwitch.isChecked) {
                blueTemp = blue
                blue = 0.0F
            }
            else {
                blue = blueTemp
            }
            screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
        }

        // Red Text Listener
        redNum.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                red = redNum.text.toString().toFloat()
                redSeek.progress = (red * 100).toInt()
                redTemp = red
                screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })

        // Green Text Listener
        greenNum.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                green = greenNum.text.toString().toFloat()
                greenSeek.progress = (green * 100).toInt()
                greenTemp = green
                screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })

        // Blue Text Listener
        blueNum.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                blue = blueNum.text.toString().toFloat()
                blueSeek.progress = (blue * 100).toInt()
                blueTemp = blue
                screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })

        // Red Seekbar Listener
        redSeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(redSeek: SeekBar, progress: Int, fromUser: Boolean) {
                red = redSeek.progress / 100.0F
                redNum.setText(red.toString())
                redTemp = red
                screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
            }
            override fun onStartTrackingTouch(redSeek: SeekBar) {}
            override fun onStopTrackingTouch(redSeek: SeekBar) {}
        })

        // Green Seekbar Listener
        greenSeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(greenSeek: SeekBar, progress: Int, fromUser: Boolean) {
                green = greenSeek.progress / 100.0F
                greenNum.setText(green.toString())
                greenTemp = green
                screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
            }
            override fun onStartTrackingTouch(greenSeek: SeekBar) {}
            override fun onStopTrackingTouch(greenSeek: SeekBar) {}
        })

        // Blue Seekbar Listener
        blueSeek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(blueSeek: SeekBar, progress: Int, fromUser: Boolean) {
                blue = blueSeek.progress / 100.0F
                blueNum.setText(blue.toString())
                blueTemp = blue
                screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
            }
            override fun onStartTrackingTouch(blueSeek: SeekBar) {}
            override fun onStopTrackingTouch(blueSeek: SeekBar) {}
        })

        // Reset Button Listener
        reset.setOnClickListener {
            red = 0.5F
            redTemp = red
            redNum.setText(red.toString())
            redSeek.progress = (red * 100).toInt()
            green = 0.8F
            greenTemp = green
            greenNum.setText(green.toString())
            greenSeek.progress = (green * 100).toInt()
            blue = 0.3F
            blueTemp = blue
            blueNum.setText(blue.toString())
            blueSeek.progress = (blue * 100).toInt()

            redSwitch.isChecked = true
            redSeek.isEnabled = redSwitch.isChecked
            redNum.isEnabled = redSwitch.isChecked
            greenSwitch.isChecked = true
            greenSeek.isEnabled = greenSwitch.isChecked
            greenNum.isEnabled = greenSwitch.isChecked
            blueSwitch.isChecked = true
            blueSeek.isEnabled = blueSwitch.isChecked
            blueNum.isEnabled = blueSwitch.isChecked

            screen.setBackgroundColor(Color.rgb((255 * red).toInt(), (255 * green).toInt(), (255 * blue).toInt()))
        }
    }
}
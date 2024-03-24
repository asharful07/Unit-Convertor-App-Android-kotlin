package com.example.unitconverterapplication

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.unitconverterapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedValue1: String
    private lateinit var selectedValue2: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mySpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedValue1 = parent?.getItemAtPosition(position).toString()
            }

        }
        binding.mySpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedValue2 = parent?.getItemAtPosition(position).toString()
            }
        }
        binding.reloadBtn.setOnClickListener {
            reloadPage(it)
        }
        binding.convertBtn.setOnClickListener {
            val input = binding.myInputNumber.text.toString().toFloat()
            when {
                selectedValue1 == selectedValue2 -> {
                    Toast.makeText(this,"please choose different Unit",Toast.LENGTH_SHORT).show()
                }
                selectedValue1 == "Meter" && selectedValue2 == "Centimeter" -> {
                    binding.myResult.text = "${(input * 100)} cm"
                }
                selectedValue1 == "Centimeter" && selectedValue2 == "Meter" -> {
                    binding.myResult.text = "${(input / 100)} m"
                }
                selectedValue1 == "kilogram" && selectedValue2 == "Gram" -> {
                    binding.myResult.text = "${(input * 1000)}g"
                }
                selectedValue1 == "Gram" && selectedValue2 == "kilogram" -> {
                    binding.myResult.text = "${(input / 1000)}Kg"
                }
                selectedValue1 == "Celsius" && selectedValue2 == "Fahrenheit" -> {
                    binding.myResult.text = "${(input * 9 / 5 + 32)}℉"
                }
                selectedValue1 == "Fahrenheit" && selectedValue2 == "Celsius" -> {
                    binding.myResult.text = "${((5 / 9) * (input - 32))}°C"
                }
                // Add more cases if needed
                else -> {
                   Toast.makeText(this,"please choose a valid unit",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun reloadPage(it: View?) {
        binding.myResult.text=""
        binding.myInputNumber.text.clear()
        binding.mySpinner1.setSelection(0)
        binding.mySpinner2.setSelection(0)
    }
}
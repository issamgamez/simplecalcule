package com.second.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnAdd: Button
    private lateinit var btnMinus: Button
    private lateinit var btnMultiplication: Button
    private lateinit var btnDivision: Button
    private lateinit var btnClear: Button
    private lateinit var numA: EditText
    private lateinit var numB: EditText
    private lateinit var showResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //display a short message in the depart
        Toast.makeText(this,"made by El Gamez Issam",Toast.LENGTH_SHORT).show()

        btnAdd = findViewById(R.id.btn_add)
        btnMinus = findViewById(R.id.btn_minus)
        btnMultiplication = findViewById(R.id.btn_multiplication)
        btnDivision = findViewById(R.id.btn_division)
        btnClear = findViewById(R.id.btn_clear)
        numA = findViewById(R.id.numA)
        numB = findViewById(R.id.numB)
        showResult = findViewById(R.id.result)

        btnAdd.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnMultiplication.setOnClickListener(this)
        btnDivision.setOnClickListener(this)
        btnClear.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val valueA = numA.text.toString().toDoubleOrNull() ?: 0.0 // Handle empty input or non-numeric values
        val valueB = numB.text.toString().toDoubleOrNull() ?: return // Exit if second input is empty or non-numeric

        if (valueB == 0.0) {
            // Display error message
            Toast.makeText(this, "Error in the second value ", Toast.LENGTH_SHORT).show()
            return
        }

        var result = 0.0
        when (v.id) {
            R.id.btn_add -> result = valueA + valueB
            R.id.btn_minus -> result = valueA - valueB
            R.id.btn_division -> result = valueA / valueB
            R.id.btn_multiplication -> result = valueA * valueB
            R.id.btn_clear -> {
                numA.text.clear()
                numB.text.clear()
                showResult.text = ""
            }

        }
        showResult.text = result.toString()
    }
}

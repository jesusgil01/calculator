package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.E
import kotlin.math.log
import kotlin.math.sin
import kotlin.math.sqrt

const val SUMA = 1
const val RESTA = 2
const val MULTIPLICACION = 3
const val DIVISION = 4
const val SQRT = 5;
const val LOG = 6;
const val SIN = 7;
const val NINGUNA = 0

class MainActivity : AppCompatActivity() {

    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = NINGUNA
    private var resultado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numeroPresionado(view: View) {
        val num = findViewById<Button>(view.id).text
        val txtInput = findViewById<TextView>(R.id.txtInput)
        var res = 0.00
        if (txtInput.text.toString().startsWith("0"))
            txtInput.setText("$num")
        else
            txtInput.setText("${txtInput.text}$num")
    }
}
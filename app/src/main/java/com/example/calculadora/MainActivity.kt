package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.*

const val SUMA = 1
const val RESTA = 2
const val MULTIPLICACION = 3
const val DIVISION = 4
const val SQRT = 5
const val LOG = 6
const val SIN = 7
const val COS = 8
const val TAN = 9
const val LN = 10
const val POW = 11
const val FACT = 12
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
        if (txtInput.text.toString().startsWith("0"))
            txtInput.setText("$num")
        else
            txtInput.setText("${txtInput.text}$num")
        if (operacion == NINGUNA)
            num1 = txtInput.text.toString().toDouble()
        else
            num2 = txtInput.text.toString().toDouble()
        resultado = false
    }

    fun operacionPresionada(view: View) {
        val op = findViewById<Button>(view.id).text
        val txtSign = findViewById<TextView>(R.id.txtSign)
        val txtInput = findViewById<TextView>(R.id.txtInput)
        txtSign.setText("$op")
        if (resultado) num1= txtInput.text.toString().toDouble()
        when (op) {
            "+" -> operacion = SUMA
            "-" -> operacion = RESTA
            "x" -> operacion = MULTIPLICACION
            "/" -> operacion = DIVISION
            "√" -> operacion = SQRT
            "log" -> operacion = LOG
            "sin" -> operacion = SIN
            "cos" -> operacion = COS
            "tan" -> operacion = TAN
            "ln" -> operacion = LN
            "^" -> operacion = POW
            "!" -> operacion = FACT
        }
        txtInput.setText("0")
    }

    fun igualPresionado(view: View) {
        val txtInput = findViewById<TextView>(R.id.txtInput)
        val res = when(operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> {
                if (num2 != 0.00)
                    num1 / num2
                else
                    "ERROR"
            }
            SQRT -> sqrt(num2)
            LOG -> log(num2, 10.00)
            SIN -> sin(num2)
            COS -> cos(num2)
            TAN -> tan(num2)
            LN -> ln(num2)
            POW -> num1.pow(num2)
            FACT -> factorial(num2)
            else -> 0
        }
        txtInput.setText("$res")
        print("dummy")
    }

    fun clear(view: View) {
        val txtInput = findViewById<TextView>(R.id.txtInput)
        txtInput.setText("0")
        num1 = 0.00
        num2 = 0.00
        operacion = NINGUNA
    }

    fun del(view: View){
        val txtInput = findViewById<TextView>(R.id.txtInput)
        val tam = txtInput.text.toString().length
        txtInput.setText(txtInput.text.toString().substring(0, tam-1))
    }

    fun factorial(num: Double): Double {
        if (num >= 1)
            return num * factorial(num - 1)
        else
            return 1.00
    }


}
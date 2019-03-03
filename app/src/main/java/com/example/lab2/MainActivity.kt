package com.example.lab2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun checkNumberInEditText(v: View): Boolean {
            val edTxtNum1 = editTextNumber1.text.isEmpty()
            val edTxtNum2 = editTextNumber2.text.isEmpty()

            if (edTxtNum1 && edTxtNum2) {
                Snackbar.make(v, "Заполните поле 1 и поле 2", Snackbar.LENGTH_LONG).show()
                return false
            } else {
                if (edTxtNum1) {
                    Snackbar.make(v, "Заполните поле 1", Snackbar.LENGTH_LONG).show()
                    return false
                }

                if (edTxtNum2) {
                    Snackbar.make(v, "Заполните поле 2", Snackbar.LENGTH_LONG).show()
                    return false
                }
            }

            return true
        }

        buttonAddition.setOnClickListener { v ->
            if (checkNumberInEditText(v)) {
                val number1: Int = editTextNumber1.text.toString().toInt()
                val number2: Int = editTextNumber2.text.toString().toInt()

                textViewResult.text = (number1 + number2).toString()
            }
        }

        buttonSubtraction.setOnClickListener { v ->
            if (checkNumberInEditText(v)) {
                val number1: Int = editTextNumber1.text.toString().toInt()
                val number2: Int = editTextNumber2.text.toString().toInt()

                textViewResult.text = (number1 - number2).toString()
            }
        }

        buttonMultiplication.setOnClickListener { v ->
            if (checkNumberInEditText(v)) {
                val number1: Int = editTextNumber1.text.toString().toInt()
                val number2: Int = editTextNumber2.text.toString().toInt()

                textViewResult.text = (number1 * number2).toString()
            }
        }

        buttonDivision.setOnClickListener { v ->
            if (checkNumberInEditText(v)) {
                val number1: Int = editTextNumber1.text.toString().toInt()
                val number2: Int = editTextNumber2.text.toString().toInt()

                if(number2 == 0) {
                    Snackbar.make(v, "Для выполнения операции деления запишите в поле 2 число отличное от нуля", Snackbar.LENGTH_LONG).show()
                    textViewResult.text = "Деление на ноль невозможно"
                }
                else
                    textViewResult.text = (number1 / number2).toString()
            }
        }
    }
}

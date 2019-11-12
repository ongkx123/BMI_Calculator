package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        if(editTextWeight.text.isBlank()){
            editTextWeight.setError(getString(R.string.input_error))
            return
        }

        if(editTextHeight.text.isBlank()){
            editTextHeight.setError(getString(R.string.input_error))
            return
        }

        val weigth = editTextWeight.text.toString().toFloat()
        val height = editTextHeight.text.toString().toFloat()

        val bmi = weigth/(height/100).pow(2)

        if(bmi < 18.5){
            textViewBMI.text = String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.under))

            imageView.setImageResource(R.drawable.under)
        }
        else if(bmi in 18.5 .. 25.0){
            textViewBMI.text = String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.normal))

            imageView.setImageResource(R.drawable.normal)
        }
        else if(bmi > 25){
            textViewBMI.text = String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.over))

            imageView.setImageResource(R.drawable.over)
        }

    }
    fun reset(view:View){

        editTextHeight.setText("")
        editTextWeight.setText("")
        textViewBMI.setText("BMI :")
        imageView.setImageResource(R.drawable.empty)
        Toast.makeText(this,"Reset", Toast.LENGTH_SHORT).show()
    }
}

package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    class Dice(val sayi1:Int,val sayi2: Int){
        fun roll():String{
            if (sayi2>sayi1){
                return (sayi1..sayi2).random().toString()
            } else{
                return (sayi2..sayi1).random().toString()
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button= findViewById(R.id.button)
        val editText1 :EditText=findViewById(R.id.editTextNumber2)
        val editText2 :EditText=findViewById(R.id.editTextNumber3)


        rollButton.setOnClickListener{
            val resultTextView : TextView= findViewById(R.id.textView2)

            if ((editText1.text.trim().isNotEmpty()) && (editText2.text.trim().isNotEmpty())){
                val ilkZar=Dice(editText1.text.toString().toInt(),editText2.text.toString().toInt())//sinif tanımlama

                resultTextView.text=ilkZar.roll()


            } else{
                val toast:Toast= Toast.makeText(this, "Lütfen sayi girin", Toast.LENGTH_SHORT)
                toast.show()
            }






        }
    }
}
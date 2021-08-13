package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast

class MyCart : AppCompatActivity() {

    private lateinit var continueButton : Button

    private lateinit var myShopsButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        continueButton = findViewById(R.id.confirm_button)
        myShopsButton = findViewById(R.id.misCompras_Button)
        continueButton.setOnClickListener {
            intentPagar()
        }
        myShopsButton.setOnClickListener {

        }
    }

    fun intentPagar(){
        Toast.makeText(this, "Compra realizada", Toast.LENGTH_LONG).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
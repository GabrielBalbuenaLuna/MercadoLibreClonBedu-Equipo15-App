package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyAccount : AppCompatActivity() {
    private lateinit var buttonCompras: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        buttonCompras = findViewById(R.id.buttonCompras)

        buttonCompras.setOnClickListener {
            val intent = Intent(this, MisCompras::class.java)
            startActivity(intent)
        }
    }


}
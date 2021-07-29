package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var buttonProductView: Button

    private lateinit var buttonFavoritesView: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonProductView = findViewById(R.id.buttonProductView)
        buttonFavoritesView = findViewById(R.id.buttonFavoritesView)


        buttonProductView.setOnClickListener {
            val intent1 = Intent(this, ProductActivity::class.java)
            startActivity(intent1)
        }

        buttonFavoritesView.setOnClickListener {
            val intent2 = Intent(this, FavoritesActivity::class.java)
            startActivity(intent2)
        }

        var buttonLogIn = findViewById<Button>(R.id.LogIn)
        buttonLogIn.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }

        var buttonRegister = findViewById<Button>(R.id.Register)
        buttonRegister.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }

}
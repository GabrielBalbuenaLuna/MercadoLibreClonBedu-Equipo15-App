package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import io.paperdb.Paper


class MainActivity : AppCompatActivity() {

    private lateinit var buttonProductView: Button
    private lateinit var buttonFavoritesView: Button
    private lateinit var buttonMyAccount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Paper.init(this)
        setContentView(R.layout.activity_main)

        buttonProductView = findViewById(R.id.buttonProductView)
        buttonFavoritesView = findViewById(R.id.buttonFavoritesView)
        buttonMyAccount = findViewById(R.id.buttonMyAccount)


        buttonProductView.setOnClickListener {
            val intent1 = Intent(this, MainProductList::class.java)
            startActivity(intent1)
        }

        buttonFavoritesView.setOnClickListener {
            val intent2 = Intent(this, FavoritesActivity::class.java)
            startActivity(intent2)
        }
        buttonMyAccount.setOnClickListener {
            val intent3 = Intent(this, MyAccount::class.java)
            startActivity(intent3)
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
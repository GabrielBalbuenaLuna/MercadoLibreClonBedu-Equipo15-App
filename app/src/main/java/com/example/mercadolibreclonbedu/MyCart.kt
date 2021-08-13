package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast

class MyCart : AppCompatActivity() {

    private lateinit var misComprasButton : RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        misComprasButton = findViewById(R.id.misCompras_Button)
        misComprasButton.setOnClickListener {
            intentPagar()
        }
    }

    fun intentPagar(){
        Toast.makeText(this, "Presionaste el boton mis compras", Toast.LENGTH_LONG).show()
        val intent = Intent(this, Pagar::class.java)
        startActivity(intent)

    }

}
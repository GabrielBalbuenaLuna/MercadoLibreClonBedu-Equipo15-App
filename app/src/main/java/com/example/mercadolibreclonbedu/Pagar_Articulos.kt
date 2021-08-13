package com.example.mercadolibreclonbedu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Pagar_Articulos : AppCompatActivity() {

    private lateinit var include : View

    private lateinit var modalButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagar_articulos)

        include = findViewById(R.id.layout_include)

        modalButton = findViewById(R.id.modal_button)

        modalButton.setOnClickListener {
            hideInclude()
        }
    }

    fun hideInclude(){
        include.visibility = View.GONE
    }



}
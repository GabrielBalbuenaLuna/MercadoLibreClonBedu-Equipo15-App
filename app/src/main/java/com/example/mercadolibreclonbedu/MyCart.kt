package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment

class MyCart : AppCompatActivity() {

    private lateinit var continueButton : AppCompatButton

    private lateinit var myShopsButton : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagar_articulos)

        continueButton = findViewById(R.id.confirm_button)
        myShopsButton = findViewById(R.id.misComprasButton)
        continueButton.setOnClickListener {
            intentPagar()
        }
        myShopsButton.setOnClickListener {
            Log.v("Listener", "ImageView")
            loadFragment(MisComprasFragment())
            Log.v("Listener", "ImageViewPostBoton")
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.replace_view_group, fragment)

        /*if (addToBackstack) {
            transaction.addToBackStack(null)
        }*/
        transaction.commit()
    }


    fun intentPagar(){
        Toast.makeText(this, "Compra realizada", Toast.LENGTH_LONG).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
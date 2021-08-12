package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.password
import kotlinx.coroutines.*

class Register : AppCompatActivity() {

    private lateinit var buttonReg: Button
    private lateinit var user: TextInputEditText
    private lateinit var pass: TextInputEditText
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonReg = findViewById(R.id.buttonSignUp)
        user = findViewById(R.id.username)
        pass = findViewById(R.id.password)
        progress = findViewById(R.id.progress)


        loginText.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener {
            if(email.text?.trim()!!.isNotEmpty() && pass.text?.trim()!!.isNotEmpty() && user.text?.trim()!!.isNotEmpty() && fullname.text?.trim()!!.isNotEmpty()) {
                Toast.makeText(this, "Welcome :)", Toast.LENGTH_LONG).show()
                progress.setVisibility(View.VISIBLE)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "There are empty fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}
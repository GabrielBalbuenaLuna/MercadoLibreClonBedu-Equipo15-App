package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_log_in.*

class LogIn : AppCompatActivity() {

    private lateinit var buttonLog: Button
    private lateinit var user: TextInputEditText
    private lateinit var pass: TextInputEditText
    private lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        buttonLog = findViewById(R.id.buttonLogin)
        user = findViewById(R.id.username)
        pass = findViewById(R.id.password)
        progress = findViewById(R.id.progress)



        buttonLogin.setOnClickListener {

            if(user.text?.trim()!!.isNotEmpty() && password.text?.trim()!!.isNotEmpty()){
                if (user.text?.trim().toString() == "root" && password.text?.trim().toString() == "1234"){
                    progress.setVisibility(View.VISIBLE)
                    Toast.makeText(this, "Welcome :)", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Please verify your input", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "There are empty fields", Toast.LENGTH_LONG).show()
            }

        }

        signUpText.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

}
package com.example.mercadolibreclonbedu

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.fragment.app.Fragment
import io.paperdb.Paper
import kotlinx.android.synthetic.main.fragment_login.*


class MainActivity : AppCompatActivity() {

    /*private lateinit var buttonProductView: Button
    private lateinit var buttonFavoritesView: Button
    private lateinit var buttonMyAccount: Button*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Paper.init(this)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, MainFragment())
                .commit()
        }

        // Mensaje Iniciando sesión
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading ...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        Handler().postDelayed({progressDialog.dismiss()},3000)

    }


    fun navigateTo(fragment: Fragment, addToBackstack: Boolean) {
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)

        if (addToBackstack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }
}
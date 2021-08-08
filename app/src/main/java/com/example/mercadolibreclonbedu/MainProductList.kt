package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import android.view.Surface
import androidx.appcompat.app.AppCompatActivity

class MainProductList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_productlist)

        val listFragment = supportFragmentManager.findFragmentById(R.id.fragmentList) as ListFragment

        listFragment.setListener{
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.PRODUCT,it)
            startActivity(intent)
        }
    }
}
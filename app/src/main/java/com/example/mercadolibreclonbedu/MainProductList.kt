package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Guideline

class MainProductList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_productlist)

        val bundle = intent.extras

        val listProduct : ArrayList<Product> = bundle?.getParcelableArrayList<Product>("LISTA") as ArrayList<Product>

        val args = Bundle()

        args.putParcelableArrayList("LISTB", listProduct)

        val guideline = findViewById<Guideline>(R.id.half)

        val listFragment = supportFragmentManager.findFragmentById(R.id.fragmentList) as ListFragment
        listFragment.arguments = args
        listFragment.setListener{
            val productFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as? ProductFragment
            if(productFragment!=null){
                productFragment.showProduct(it)
            } else {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.PRODUCT, it)
                startActivity(intent)
            }
        }
    }
}
package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Guideline
import java.lang.NullPointerException

class MainProductList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_productlist)

        val bundle = intent.extras
        var listProduct = ArrayList<Product>()
        try {
             listProduct = bundle?.getParcelableArrayList<Product>("LISTA") as ArrayList<Product>
        } catch (Exception : NullPointerException) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
//            listProduct.add(Product("Wish List Empty", "", 0f, 0, 0, arrayListOf(), arrayListOf()))
        }

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
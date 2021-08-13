package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_product.*
import kotlinx.android.synthetic.main.item_product.*

class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        val bundle = intent.extras
        println("Que es bundle" + bundle)
        val productFav : Product? = bundle?.getParcelable("Fav")
        val args = Bundle()
        args.putParcelable("productFav", productFav)
        val listFragmentFavorites = supportFragmentManager.findFragmentById(R.id.fragmentListFavorites) as FavoritesListFragment
        println("Que es bundle? "+ args)
        listFragmentFavorites.arguments = args
        listFragmentFavorites.setListener {
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
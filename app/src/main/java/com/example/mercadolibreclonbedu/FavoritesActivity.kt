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
        val productFav : Product? = bundle?.getParcelable("Fav")
        val args = Bundle()
        args.putParcelable("productFav", productFav)
        val listFragmentFavorites = supportFragmentManager.findFragmentById(R.id.fragmentListFavorites) as FavoritesListFragment
        listFragmentFavorites.arguments = args
        listFragmentFavorites.setListener {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.PRODUCT, it)
                startActivity(intent)

        }

    }
}
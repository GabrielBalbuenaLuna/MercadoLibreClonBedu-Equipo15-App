package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import io.paperdb.Paper
import kotlinx.android.synthetic.main.fragment_list.*

class FavoritesActivity : AppCompatActivity()  {

    private lateinit var mAdapter : RecyclerAdapterFavoriteProduct
    private var listener : (Product) ->Unit = {}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        val recycler = findViewById<RecyclerView>(R.id.recyclerFavoriteProducts)

        recycler.setHasFixedSize(true)

        var productList = mutableListOf<Product>()

//        productList = (intent.getSerializableExtra("favoriteItems") as List<Product>).toMutableList()
            productList.add(intent.getParcelableExtra("Fav")!!)
//          productList = intent.getParcelableExtra("Fav")!!
//        intent.getParcelableExtra<Product>(DetailActivity.PRODUCT)

//        if (productList == null) {
//            productList = Product("Wish List Empty", "", 0f, 0, 0, arrayListOf(), arrayListOf())
//        }

        listener = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.PRODUCT, it)
            startActivity(intent)
        }

        mAdapter = RecyclerAdapterFavoriteProduct(this, productList!!, listener)

        recycler.adapter = mAdapter
    }




}
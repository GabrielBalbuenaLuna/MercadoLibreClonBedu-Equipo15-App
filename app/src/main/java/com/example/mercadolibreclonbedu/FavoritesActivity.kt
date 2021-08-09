package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*

class FavoritesActivity : AppCompatActivity()  {

    private lateinit var mAdapter : RecyclerAdapterFavoriteProduct
    private var listener : (Product) ->Unit = {}

//    var productList = mutableListOf<Product>()

//    val productList = mutableListOf<Product> (
//        Product("Devil may cry 5", "$300", 2.5f, 5, R.drawable.shoes, arrayListOf("https://bit.ly/2YoJ77H", "https://bit.ly/2BteuF2", "https://bit.ly/3fLJf72", "https://bit.ly/3fLJf72"), arrayListOf("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32cm, Width: 22 cm, Heel: 5 cm", "Height: 34cm, Width: 24 cm, Heel: 5 cm"))
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        val recycler = findViewById<RecyclerView>(R.id.recyclerFavoriteProducts)

        recycler.setHasFixedSize(true)

//        productList = (intent.getSerializableExtra("favoriteItems") as List<Product>).toMutableList()
        var productList = intent.getParcelableExtra<Product>("Fav")
//        intent.getParcelableExtra<Product>(DetailActivity.PRODUCT)

        if (productList == null) {
            productList = Product("Wish List Empty", "", 0f, 0, 0, arrayListOf(), arrayListOf())
        }

        mAdapter = RecyclerAdapterFavoriteProduct(this, productList!!, listener)
        println("Antes de darme")

        recycler.adapter = mAdapter
        listener = {
            println("Me diste click")
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.PRODUCT, it)
            startActivity(intent)
        }
    }




}
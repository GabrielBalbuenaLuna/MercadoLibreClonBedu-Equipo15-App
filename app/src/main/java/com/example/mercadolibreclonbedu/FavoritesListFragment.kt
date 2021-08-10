package com.example.mercadolibreclonbedu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.recyclerProducts
import java.lang.NullPointerException

class FavoritesListFragment : Fragment() {

    private lateinit var mAdapter : RecyclerAdapterFavoriteProduct
    private var listener : (Product) ->Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // infla el layout para este Fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    //generamos datos dummy con este método
    private fun getProducts(): MutableList<Product>{
        var productList = mutableListOf<Product>()

//        productList = (intent.getSerializableExtra("favoriteItems") as List<Product>).toMutableList()
        try {
            val product : Product? = arguments?.getParcelable("productFav")
            productList.add(product!!)
//            productList.add(Product("Wish List Empty", "", 0f, 0, 0, arrayListOf(), arrayListOf()))
        } catch (Exception: NullPointerException) {
            productList.add(Product("Wish List Empty", "", 0f, 0, 0, arrayListOf(), arrayListOf()))
        }
        return productList
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView(){
        // indicamos que tiene un tamaño fijo
        recyclerFavoriteProducts.setHasFixedSize(true)
        // indicamos el tipo de layoutManager
        recyclerFavoriteProducts.layoutManager = LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapterFavoriteProduct( requireActivity(), getProducts(), listener)
        //asignando el Adapter al RecyclerView
        recyclerFavoriteProducts.adapter = mAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
    }

    fun setListener(l: (Product) ->Unit){
        listener = l
    }



}
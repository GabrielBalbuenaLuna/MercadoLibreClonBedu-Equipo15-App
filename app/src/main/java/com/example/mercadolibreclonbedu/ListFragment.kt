package com.example.mercadolibreclonbedu

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_list.*
import java.io.IOException
import java.io.InputStream
import java.util.ArrayList


class ListFragment : Fragment() {

    private lateinit var mAdapter : RecyclerAdapterProduct
    private var listener : (Product) ->Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // infla el layout para este Fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    //generamos datos dummy con este método
    private fun getProducts(): MutableList<Product>{

        val listProducts : ArrayList<Product>? = arguments?.getParcelableArrayList<Product>("LISTB")

        return listProducts!!
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView(){
        // indicamos que tiene un tamaño fijo
        recyclerProducts.setHasFixedSize(true)
        // indicamos el tipo de layoutManager
        recyclerProducts.layoutManager = LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapterProduct( requireActivity(), getProducts(), listener)
        //asignando el Adapter al RecyclerView
        recyclerProducts.adapter = mAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
    }

    fun setListener(l: (Product) ->Unit){
        listener = l
    }

    fun loadData(context: Context): String? {
        val jsonString: String

        try {
            jsonString = context.assets.open("products.json").bufferedReader().use { it.readText() }

            return jsonString
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }



}
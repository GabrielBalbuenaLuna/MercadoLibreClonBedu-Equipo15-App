package com.example.mercadolibreclonbedu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import java.io.InputStream


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
        var products:MutableList<Product> = ArrayList()
        val imageList = arrayListOf<String>("https://bit.ly/2YoJ77H", "https://bit.ly/2BteuF2", "https://bit.ly/3fLJf72", "https://bit.ly/3fLJf72")
        val sizesList = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32cm, Width: 22 cm, Heel: 5 cm", "Height: 34cm, Width: 24 cm, Heel: 5 cm")

        products.add(Product("Control ps5", "$1400",4.6f, 10, R.drawable.shoes, imageList, sizesList))

        return products
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



}
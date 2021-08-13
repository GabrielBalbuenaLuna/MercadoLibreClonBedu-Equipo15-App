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
import java.lang.NullPointerException
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

        var listProducts = ArrayList<Product> ()
        try {
            listProducts = arguments?.getParcelableArrayList<Product>("LISTB") as ArrayList<Product>
        } catch (e: NullPointerException) {
            val imageList = arrayListOf<String>("https://m.media-amazon.com/images/I/61zR1uOYBQL._AC_SY395_.jpg", "https://www.beatnikshoes.com/wp-content/uploads/2017/05/Corso-Blues-1.jpg", "https://i.linio.com/p/5951918144c99a80f4d5b1db7a3afa8a-product.jpg")
            val sizesList = arrayListOf<String>("Height: 25 cm, Width: 20 cm, Heel: 5 cm", "Height: 29cm, Width: 22 cm, Heel: 5 cm", "Height: 34cm, Width: 24 cm, Heel: 5 cm")

            val imageList2 = arrayListOf<String>("https://static.dafiti.com.co/p/puma-3211-695701-1-product.jpg", "https://static.dafiti.com.co/p/puma-4907-9016801-1-product.jpg", "https://www.futbolemotion.com/imagesarticulos/145421/540/chaqueta-puma-ac-milan-stadium-2020-2021-negro-0.jpg")
            val sizesList2 = arrayListOf<String>("Height: 68 cm, Width: 45 cm, Heel: 100 cm", "Height: 70 cm, Width: 56 cm, Heel: 115 cm", "Height: 74 cm, Width: 72 cm, Heel: 125 cm")

            val imageList3 = arrayListOf<String>("https://ss237.liverpool.com.mx/xl/1091077815.jpg", "https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/d285610e30664900b857a7fa00ed0201_9366/Tenis_Superstar_Blanco_C77124_01_standard.jpg", "https://www.dpstreet.mx/wcsstore/ExtendedSitesCatalogAssetStore/images/catalog/zoom/1019110-0100V1.jpg")
            val sizesList3 = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32 cm, Width: 22 cm, Heel: 5 cm", "Height: 34 cm, Width: 24 cm, Heel: 5 cm")

            val imageList4 = arrayListOf<String>("https://http2.mlstatic.com/D_NQ_NP_937478-MLM31220133230_062019-O.jpg", "https://ss357.liverpool.com.mx/xl/1068658566.jpg", "https://cdn.shopify.com/s/files/1/0071/3850/8859/products/805289305026_1600x1067.png?v=1539209159")
            val sizesList4 = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32 cm, Width: 22 cm, Heel: 5 cm", "Height: 34 cm, Width: 24 cm, Heel: 5 cm")

            val imageList5 = arrayListOf<String>("https://allinoutfits.com/wp-content/uploads/Outfit-pantalon-beige-con-bolsillos-hombre.jpg", "https://i.pinimg.com/originals/48/a0/b0/48a0b0d03f401eabdb24b88b5158e4ec.jpg", "https://images-na.ssl-images-amazon.com/images/I/516Q7qJOisL._AC_UX342_.jpg")
            val sizesList5 = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32 cm, Width: 22 cm, Heel: 5 cm", "Height: 34 cm, Width: 24 cm, Heel: 5 cm")

            listProducts.add(Product("Men blue elegant shoes", "$450", 5f, 5, R.drawable.blue_shoes, imageList, sizesList))
            listProducts.add(Product("Men's jacket red and black", "$345",2.5f, 20, R.drawable.jacket, imageList2, sizesList2))
            listProducts.add(Product("Black men's casual sneakers", "$250",3.5f, 7, R.drawable.sneakers, imageList3, sizesList3))
            listProducts.add(Product("Brown Sunglasses", "$450",2.9f, 12, R.drawable.sunglasses_men, imageList4, sizesList4))
            listProducts.add(Product("Beige men pants", "$250",3.5f, 7, R.drawable.beige_pants, imageList5, sizesList5))
        }

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
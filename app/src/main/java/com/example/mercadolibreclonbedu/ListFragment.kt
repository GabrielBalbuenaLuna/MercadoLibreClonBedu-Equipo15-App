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
        val jsonFileString = getActivity()?.getApplicationContext()?.let { loadData(it) }
        println("MIS DATOS")
        if (jsonFileString != null) {
            println("MY DATA"+ jsonFileString)
        }
        val imageList = arrayListOf<String>("https://m.media-amazon.com/images/I/51d8XKNR0EL._AC_UL320_.jpg", "https://i.etsystatic.com/5998005/r/il/5a6624/1755302554/il_570xN.1755302554_kxaw.jpg", "https://ae01.alicdn.com/kf/HTB1k6CrLXXXXXafXXXXq6xXFXXXa/Summer-Short-Skirt-With-Safety-Undeware-Pastel-Pink-Mini-Skirts-Womens-Skater-Skirt-Pink-Tennis-Short.jpg")
        val sizesList = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32cm, Width: 22 cm, Heel: 5 cm", "Height: 34cm, Width: 24 cm, Heel: 5 cm")

        val imageList2 = arrayListOf<String>("https://static.dafiti.com.co/p/puma-3211-695701-1-product.jpg", "https://static.dafiti.com.co/p/puma-4907-9016801-1-product.jpg", "https://www.futbolemotion.com/imagesarticulos/145421/540/chaqueta-puma-ac-milan-stadium-2020-2021-negro-0.jpg")
        val sizesList2 = arrayListOf<String>("Height: 68 cm, Width: 45 cm, Heel: 100 cm", "Height: 70 cm, Width: 56 cm, Heel: 115 cm", "Height: 74 cm, Width: 72 cm, Heel: 125 cm")

        val imageList3 = arrayListOf<String>("https://ss237.liverpool.com.mx/xl/1091077815.jpg", "https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/d285610e30664900b857a7fa00ed0201_9366/Tenis_Superstar_Blanco_C77124_01_standard.jpg", "https://www.dpstreet.mx/wcsstore/ExtendedSitesCatalogAssetStore/images/catalog/zoom/1019110-0100V1.jpg")
        val sizesList3 = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32 cm, Width: 22 cm, Heel: 5 cm", "Height: 34 cm, Width: 24 cm, Heel: 5 cm")

        products.add(Product("Lady pink skirt", "$150",4.5f, 6, R.drawable.skirt, imageList, sizesList))
        products.add(Product("Men's jacket red and black", "$345",2.5f, 20, R.drawable.jacket, imageList2, sizesList2))
        products.add(Product("Black men's casual sneakers", "$250",3.5f, 7, R.drawable.sneakers, imageList3, sizesList3))

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
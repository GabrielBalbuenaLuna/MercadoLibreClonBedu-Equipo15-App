package com.example.mercadolibreclonbedu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_favorites.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.recyclerProducts
import java.lang.NullPointerException

class FavoritesListFragment : Fragment() {

    private lateinit var mAdapter : RecyclerAdapterFavoriteProduct
    private var listener : (Product) ->Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        // seteando el appbar como action bar
        (activity as AppCompatActivity).setSupportActionBar(view.favorites_bar)
        val toolbar: Toolbar = view.findViewById(R.id.favorites_bar) as Toolbar
        toolbar.setTitle("") //Ocultar el titulo por defecto
        // infla el layout para este Fragment
        return view
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
    //Agregar el menú de opciones al AppBar
    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater){
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu,menuInflater)
    }
    //asignamos las acciones para cada opción del AppBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg = ""

        when(item.itemId){
            R.id.beduHome -> {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

}
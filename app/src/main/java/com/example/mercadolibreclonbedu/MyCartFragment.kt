package com.example.mercadolibreclonbedu

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_favorites.view.*
import kotlinx.android.synthetic.main.fragment_my_cart.*
import kotlinx.android.synthetic.main.fragment_my_cart.view.*
import java.lang.NullPointerException

class MyCartFragment : Fragment() {
    private lateinit var mAdapter : RecyclerAdapterMyCartProduct
    private var listener : (Product) ->Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_cart, container, false)
        val buttonComprar = view.findViewById<AppCompatButton>(R.id.buttonComprarAhora)

        // seteando el appbar como action bar
        (activity as AppCompatActivity).setSupportActionBar(view.myCart_bar)
        val toolbar: Toolbar = view.findViewById(R.id.myCart_bar) as Toolbar
        toolbar.setTitle("") //Ocultar el titulo por defecto

        buttonComprar.setOnClickListener {
            loadFragment(Pagar())
        }

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
            productList.add(Product("My Cart List Is Empty", "", 0f, 0, 0, arrayListOf(), arrayListOf()))
        }
        return productList
    }

    //configuramos lo necesario para desplegar el RecyclerView
    private fun setUpRecyclerView(){
        // indicamos que tiene un tamaño fijo
        recyclerMyCartProducts.setHasFixedSize(true)
        // indicamos el tipo de layoutManager
        recyclerMyCartProducts.layoutManager = LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapterMyCartProduct( requireActivity(), getProducts(), listener)
        //asignando el Adapter al RecyclerView
        recyclerMyCartProducts.adapter = mAdapter
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

    private fun loadFragment(fragment: Fragment) {
        val transaction = parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}
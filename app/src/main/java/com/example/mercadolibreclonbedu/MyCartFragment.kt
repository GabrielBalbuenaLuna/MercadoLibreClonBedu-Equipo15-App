package com.example.mercadolibreclonbedu

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_favorites.view.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_my_cart.*
import kotlinx.android.synthetic.main.fragment_my_cart.view.*
import java.lang.NullPointerException

class MyCartFragment : Fragment() {
    private lateinit var mAdapter : RecyclerAdapterMyCartProduct
    private var listener : (Product) ->Unit = {}
    val precio1 =450

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
        val textView = view.findViewById<TextView>(R.id.precio_total)
        textView.text = "$$precio1"
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
        var products = mutableListOf<Product>()
        val imageList = arrayListOf<String>("https://m.media-amazon.com/images/I/61Dpcl71A0L._AC_UX695_.jpg", "https://m.media-amazon.com/images/I/61gLPSwg6yL._AC_UL1300_.jpg", "https://m.media-amazon.com/images/I/81guaxyBdgL._AC_UL1500_.jpg")
        val sizesList = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32cm, Width: 22 cm, Heel: 5 cm", "Height: 34cm, Width: 24 cm, Heel: 5 cm")
        //val imageList2 = arrayListOf<String>("https://static.dafiti.com.co/p/puma-3211-695701-1-product.jpg", "https://static.dafiti.com.co/p/puma-4907-9016801-1-product.jpg", "https://www.futbolemotion.com/imagesarticulos/145421/540/chaqueta-puma-ac-milan-stadium-2020-2021-negro-0.jpg")
        //val sizesList2 = arrayListOf<String>("Height: 68 cm, Width: 45 cm, Heel: 100 cm", "Height: 70 cm, Width: 56 cm, Heel: 115 cm", "Height: 74 cm, Width: 72 cm, Heel: 125 cm")

        products.add(Product("Men blue elegant shoes", "$$precio1", 5f, 5, R.drawable.blue_shoes, imageList, sizesList))
        //products.add(Product("Men's jacket red and black", "$345",2.5f, 20, R.drawable.jacket, imageList2, sizesList2))

        return products
    }
    private fun deleteProducts(){
        recyclerMyCartProducts.removeAllViewsInLayout()
        var newProducts = mutableListOf<Product>()
        newProducts.add(Product("My Cart List Is Empty", "", 0f, 0, 0, arrayListOf(), arrayListOf()))
        // indicamos que tiene un tamaño fijo
        recyclerMyCartProducts.setHasFixedSize(true)
        // indicamos el tipo de layoutManager
        recyclerMyCartProducts.layoutManager = LinearLayoutManager(activity)
        //seteando el Adapter
        mAdapter = RecyclerAdapterMyCartProduct( requireActivity(), newProducts, listener)
        //asignando el Adapter al RecyclerView
        recyclerMyCartProducts.adapter = mAdapter
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
        menuInflater.inflate(R.menu.toolbar_menu_mycart, menu)
        return super.onCreateOptionsMenu(menu,menuInflater)
    }

    //asignamos las acciones para cada opción del AppBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg = ""

        when(item.itemId){
            R.id.deleteAll -> {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Deleting Products")
                builder.setMessage("Do you want to delete all products?")
                builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int ->
                    deleteProducts()
                    // Cerrando Sesión
                    val progressDialog = ProgressDialog(requireActivity())
                    progressDialog.setMessage("Deleting Products...")
                    progressDialog.setCancelable(false)
                    progressDialog.show()
                    Handler().postDelayed({progressDialog.dismiss()},1500)
                })
                builder.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int -> })
                builder.show()
            }

        }

        return super.onOptionsItemSelected(item)
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }
}
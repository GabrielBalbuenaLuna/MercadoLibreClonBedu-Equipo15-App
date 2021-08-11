package com.example.mercadolibreclonbedu

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_my_account.*
import kotlinx.android.synthetic.main.fragment_my_account.view.*

class MyAccountFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_account, container, false)
        val buttonCompras = view.findViewById<AppCompatButton>(R.id.buttonCompras)

        // seteando el appbar como action bar
        (activity as AppCompatActivity).setSupportActionBar(view.myAccount_bar)
        val toolbar: Toolbar = view.findViewById(R.id.myAccount_bar) as Toolbar
        toolbar.setTitle("") //Ocultar el titulo por defecto

        buttonCompras.setOnClickListener {
            loadFragment(MyCartFragment())
        }
        return view
    }

    //Agregar el menú de opciones al AppBar
    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater){
        menuInflater.inflate(R.menu.toolbar_menu_myaccount, menu)
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
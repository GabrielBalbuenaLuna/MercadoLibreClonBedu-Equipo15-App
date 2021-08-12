package com.example.mercadolibreclonbedu

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        val buttonCompras = view.findViewById<AppCompatButton>(R.id.buttonMisCompras)

        // seteando el appbar como action bar
        (activity as AppCompatActivity).setSupportActionBar(view.myAccount_bar)
        val toolbar: Toolbar = view.findViewById(R.id.myAccount_bar) as Toolbar
        toolbar.setTitle("") //Ocultar el titulo por defecto

        buttonCompras.setOnClickListener {
            loadFragment(MisComprasFragment())
        }
        return view
    }

    //Agregar el menú de opciones al AppBar
    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater){
        menuInflater.inflate(R.menu.toolbar_menu_myaccount, menu)
        return super.onCreateOptionsMenu(menu,menuInflater)
    }

    //asignamos las acciones para cada opción del AppBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg = ""

        when(item.itemId){
            R.id.myAccountSettings -> {
                val builder = AlertDialog.Builder(requireActivity())
                builder.setTitle("Sign out from this device")
                builder.setMessage("Are you sure to log out?")
                builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int ->
                    val intent = Intent(activity, LogIn::class.java)
                    startActivity(intent)
                    // Cerrando Sesión
                    val progressDialog = ProgressDialog(requireActivity())
                    progressDialog.setMessage("Disconnecting...")
                    progressDialog.setCancelable(false)
                    progressDialog.show()
                    Handler().postDelayed({progressDialog.dismiss()},3500)
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
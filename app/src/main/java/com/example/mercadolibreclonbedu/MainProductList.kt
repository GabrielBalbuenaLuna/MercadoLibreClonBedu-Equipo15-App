package com.example.mercadolibreclonbedu

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.Guideline
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_my_account.view.*
import kotlinx.android.synthetic.main.main_productlist.*
import java.lang.NullPointerException

class MainProductList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_productlist)

        val bundle = intent.extras
        var listProduct = ArrayList<Product>()
        try {
             listProduct = bundle?.getParcelableArrayList<Product>("LISTA") as ArrayList<Product>
        } catch (Exception : NullPointerException) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
//            listProduct.add(Product("Wish List Empty", "", 0f, 0, 0, arrayListOf(), arrayListOf()))
        }

        // seteando el appbar como action bar
        setSupportActionBar(homeFragment_bar)
        val toolbar: Toolbar? = findViewById(R.id.homeFragment_bar) as? Toolbar
        toolbar?.setTitle("") //Ocultar el titulo por defecto

        val args = Bundle()

        args.putParcelableArrayList("LISTB", listProduct)

        val guideline = findViewById<Guideline>(R.id.half)

        val listFragment = supportFragmentManager.findFragmentById(R.id.fragmentList) as? ListFragment
        listFragment?.arguments = args
        println("Mis products" + listFragment?.arguments)
        println("Mis products args" + args)
        listFragment?.setListener{
            val productFragment = supportFragmentManager.findFragmentById(R.id.fragmentDetail) as? ProductFragment
            if(productFragment!=null){
                productFragment.showProduct(it)
            } else {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.PRODUCT, it)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu_home2, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //asignamos las acciones para cada opción del AppBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg = ""

        when(item.itemId){
            R.id.beduBarHome -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
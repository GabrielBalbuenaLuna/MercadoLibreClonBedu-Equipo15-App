package com.example.mercadolibreclonbedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_my_cart.view.*

class Pagar : Fragment() {

    private lateinit var payedViewGroup : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pagar, container, false)

        payedViewGroup = view.findViewById(R.id.payed)
        payedViewGroup.setOnClickListener {
            intentPagar()
            Log.v("Listener", "ImageView")
        }
        return view
    }
    fun intentPagar(){
        //Toast.makeText(requireContext(), "Presionaste el boton mis compras", Toast.LENGTH_LONG).show()
        val intent = Intent(requireContext(), MyCart::class.java)
        startActivity(intent)
    }
}



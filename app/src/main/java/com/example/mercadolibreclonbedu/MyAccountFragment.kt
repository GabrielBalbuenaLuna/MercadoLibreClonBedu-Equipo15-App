package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_my_account.*

class MyAccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_account, container, false)

        val loginButton = view.findViewById<Button>(R.id.buttonCompras)

        buttonCompras.setOnClickListener{

        }

        return view
    }
}
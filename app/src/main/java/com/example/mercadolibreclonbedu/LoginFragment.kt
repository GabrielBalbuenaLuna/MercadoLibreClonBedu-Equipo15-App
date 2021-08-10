package com.example.mercadolibreclonbedu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class LoginFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val buttonLogin = view.findViewById<MaterialButton>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            (activity as MainActivity).navigateTo(MainFragment(), false)
        }

        return view
    }
}
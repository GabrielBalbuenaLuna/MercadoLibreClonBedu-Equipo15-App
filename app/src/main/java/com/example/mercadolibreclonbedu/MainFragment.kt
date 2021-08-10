package com.example.mercadolibreclonbedu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            parentFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, FirstFragment())
                .commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.firstFragment -> { loadFragment(FirstFragment()) }
                R.id.secondFragment -> { loadFragment(SecondFragment()) }
                R.id.thirdFragment -> { loadFragment(MyCartFragment()) }
                R.id.fourthFragment -> { loadFragment(MyAccountFragment()) }
            }
            true
        }
        return view
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = parentFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, fragment)

        /*if (addToBackstack) {
            transaction.addToBackStack(null)
        }*/
        transaction.commit()

    }

}
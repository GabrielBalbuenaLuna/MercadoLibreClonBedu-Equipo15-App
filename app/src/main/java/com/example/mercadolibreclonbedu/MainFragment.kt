package com.example.mercadolibreclonbedu

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            parentFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, HomeFragment())
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
                R.id.firstFragment -> { loadFragment(HomeFragment()) }
                R.id.secondFragment -> { loadFragment(FavoritesListFragment()) }
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
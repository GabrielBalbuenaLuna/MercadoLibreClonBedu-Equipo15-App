package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private lateinit var btnMen : Button
    private lateinit var btnWomen : Button
    private lateinit var btnKids : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // infla el layout para este Fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        btnMen = view.findViewById(R.id.btnMen)
        btnWomen = view.findViewById(R.id.btnWomen)
        btnKids = view.findViewById(R.id.btnKids)

        btnMen.setOnClickListener{
            val bundle = Bundle()
            var listProducts = ArrayList<Product>()
            val imageList = arrayListOf<String>("https://m.media-amazon.com/images/I/51d8XKNR0EL._AC_UL320_.jpg", "https://i.etsystatic.com/5998005/r/il/5a6624/1755302554/il_570xN.1755302554_kxaw.jpg", "https://ae01.alicdn.com/kf/HTB1k6CrLXXXXXafXXXXq6xXFXXXa/Summer-Short-Skirt-With-Safety-Undeware-Pastel-Pink-Mini-Skirts-Womens-Skater-Skirt-Pink-Tennis-Short.jpg")
            val sizesList = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32cm, Width: 22 cm, Heel: 5 cm", "Height: 34cm, Width: 24 cm, Heel: 5 cm")

            val imageList2 = arrayListOf<String>("https://static.dafiti.com.co/p/puma-3211-695701-1-product.jpg", "https://static.dafiti.com.co/p/puma-4907-9016801-1-product.jpg", "https://www.futbolemotion.com/imagesarticulos/145421/540/chaqueta-puma-ac-milan-stadium-2020-2021-negro-0.jpg")
            val sizesList2 = arrayListOf<String>("Height: 68 cm, Width: 45 cm, Heel: 100 cm", "Height: 70 cm, Width: 56 cm, Heel: 115 cm", "Height: 74 cm, Width: 72 cm, Heel: 125 cm")

            val imageList3 = arrayListOf<String>("https://ss237.liverpool.com.mx/xl/1091077815.jpg", "https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy,c_fill,g_auto/d285610e30664900b857a7fa00ed0201_9366/Tenis_Superstar_Blanco_C77124_01_standard.jpg", "https://www.dpstreet.mx/wcsstore/ExtendedSitesCatalogAssetStore/images/catalog/zoom/1019110-0100V1.jpg")
            val sizesList3 = arrayListOf<String>("Height: 30 cm, Width: 20 cm, Heel: 5 cm", "Height: 32 cm, Width: 22 cm, Heel: 5 cm", "Height: 34 cm, Width: 24 cm, Heel: 5 cm")

            listProducts.add(Product("Lady pink skirt", "$150",4.5f, 6, R.drawable.skirt, imageList, sizesList))
            listProducts.add(Product("Men's jacket red and black", "$345",2.5f, 20, R.drawable.jacket, imageList2, sizesList2))
            listProducts.add(Product("Black men's casual sneakers", "$250",3.5f, 7, R.drawable.sneakers, imageList3, sizesList3))
            val intent = Intent(activity, MainProductList::class.java)
            bundle.putParcelableArrayList("LISTA", listProducts)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        return view
    }
}
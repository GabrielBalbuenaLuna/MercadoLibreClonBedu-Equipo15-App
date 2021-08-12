package com.example.mercadolibreclonbedu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class ProductFragment : Fragment() {

    private lateinit var productDescription: TextView
    private lateinit var productRate: RatingBar
    private lateinit var productArrival: TextView
    private lateinit var productPrice: TextView

    private lateinit var buttonAdd: Button
    private lateinit var buttonMinus: Button

    private lateinit var buttonGetBack: ImageView

    private lateinit var buttonSmallSize: Button
    private lateinit var buttonMediumSize: Button
    private lateinit var buttonLargeSize: Button

    private lateinit var quantityText: TextView
    private lateinit var sizeSpecifications: TextView

    private lateinit var imageSlider: ImageSlider


    private lateinit var addItemFav: Button


    private var quantityProduct = 1;

    // Traemos todas las views desde el layout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        imageSlider = view.findViewById(R.id.image_slider)

        productDescription = view.findViewById(R.id.productDescription)
        productRate = view.findViewById(R.id.ratingProduct)
        productPrice = view.findViewById(R.id.productPrice)
        productArrival = view.findViewById(R.id.productArrival)


        buttonGetBack = view.findViewById(R.id.getBackIcon)

        buttonAdd = view.findViewById(R.id.addProduct)
        buttonMinus = view.findViewById(R.id.minusProduct)
        quantityText = view.findViewById(R.id.quantityText)


        sizeSpecifications = view.findViewById(R.id.sizeSpecifications)

        buttonSmallSize = view.findViewById(R.id.sizeS)
        buttonMediumSize = view.findViewById(R.id.sizeM)
        buttonLargeSize = view.findViewById(R.id.sizeL)

        addItemFav = view.findViewById(R.id.addToFavbtn)


        buttonAdd.setOnClickListener {
            quantityProduct++
            quantityText.text = quantityProduct.toString()
        }

        buttonMinus.setOnClickListener {
            if (quantityProduct > 1) {
                quantityProduct--
                quantityText.text = quantityProduct.toString()
            }
        }

        buttonGetBack.setOnClickListener {
            //val intent = Intent(activity, MainFragment::class.java)
            //startActivity(intent)
            (activity as MainActivity).navigateTo(MainFragment(),false)
        }


        return view
    }

    fun showProduct(product: Product){
        view?.visibility = View.VISIBLE
        productDescription.text = product.name
        productRate.rating = product.rating
        productPrice.text = product.price
        val days = product.arrival.toString()
        productArrival.text = "Arrives in $days days"
//        imageSlider.setImageList(product.setImages, ScaleTypes.FIT)
        val imageList = ArrayList<SlideModel>()


        for (image in product.setImages!!) {
            imageList.add(SlideModel(image))
        }
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        buttonSmallSize.setOnClickListener {
            buttonSmallSize.setBackgroundResource(R.drawable.rounded_button_white)
            buttonMediumSize.setBackgroundResource(R.drawable.rounded_deselect)
            buttonLargeSize.setBackgroundResource(R.drawable.rounded_deselect)
            sizeSpecifications.text = product.setSizes[0]
        }

        buttonMediumSize.setOnClickListener {
            buttonMediumSize.setBackgroundResource(R.drawable.rounded_button_white)
            buttonSmallSize.setBackgroundResource(R.drawable.rounded_deselect)
            buttonLargeSize.setBackgroundResource(R.drawable.rounded_deselect)
            sizeSpecifications.text = product.setSizes[1]
        }


        buttonLargeSize.setOnClickListener {
            buttonSmallSize.setBackgroundResource(R.drawable.rounded_deselect)
            buttonMediumSize.setBackgroundResource(R.drawable.rounded_deselect)
            buttonLargeSize.setBackgroundResource(R.drawable.rounded_button_white)
            sizeSpecifications.text = product.setSizes[2]
        }

        addItemFav.setOnClickListener {
            val intent = Intent(activity, FavoritesActivity::class.java)
            intent.putExtra("Fav", product)
            startActivity(intent)
        }


    }

}

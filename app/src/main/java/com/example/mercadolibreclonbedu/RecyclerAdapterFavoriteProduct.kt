package com.example.mercadolibreclonbedu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterFavoriteProduct(
    private val context: Context,
    private val product: Product,
    private val clickListener: (Product) -> Unit): RecyclerView.Adapter<RecyclerAdapterFavoriteProduct.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_favorites, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val product = products.get(position)
        holder.bind(product, context)

        holder.view.setOnClickListener{clickListener(product)}
    }


    override fun getItemCount(): Int {
        return 1
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        //obteniendo las referencias a las Views
        val favoriteItemName = view.findViewById(R.id.cardFavoriteDescription) as TextView
        val favoriteItemPrice = view.findViewById(R.id.cardFavoritePrice) as TextView
        val favoriteItemImage = view.findViewById(R.id.cardFavoriteImage) as ImageView
        val favoriteItemArrival = view.findViewById(R.id.cardFavoriteDelivery) as TextView
        val favoriteItemAddCart = view.findViewById(R.id.cardAddCart) as TextView

        //"atando" los datos a las Views
        fun bind(product: Product, context: Context){

            if (product.name == "Wish List Empty") {
                favoriteItemArrival.visibility = View.INVISIBLE
                favoriteItemImage.visibility = View.INVISIBLE
                favoriteItemPrice.visibility = View.INVISIBLE
                favoriteItemAddCart.visibility = View.INVISIBLE

            }
            favoriteItemName.text = product.name
            favoriteItemPrice.text = product.price
            favoriteItemImage.setImageResource(product.idImage)
            favoriteItemArrival.text = "Arrives in ${product.arrival.toString()} days"


        }
    }

}
package com.example.mercadolibreclonbedu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterMyCartProduct(
    private val context: Context,
    private val products: MutableList<Product>,
    private val clickListener: (Product) -> Unit): RecyclerView.Adapter<RecyclerAdapterMyCartProduct.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_mycart, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.bind(product, context)

        holder.view.setOnClickListener{clickListener(product)}
    }


    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        //obteniendo las referencias a las Views
        val favoriteItemName = view.findViewById(R.id.cardMyCartDescription) as TextView
        val favoriteItemPrice = view.findViewById(R.id.cardMyCartPrice) as TextView
        val favoriteItemImage = view.findViewById(R.id.cardMyCartImage) as ImageView
        val favoriteItemArrival = view.findViewById(R.id.cardMyCartDelivery) as TextView

        //"atando" los datos a las Views
        fun bind(product: Product, context: Context){

            if (product.name == "My Cart List Is Empty") {
                favoriteItemArrival.visibility = View.INVISIBLE
                favoriteItemImage.visibility = View.INVISIBLE
                favoriteItemPrice.visibility = View.INVISIBLE

            }
            favoriteItemName.text = product.name
            favoriteItemPrice.text = product.price
            favoriteItemImage.setImageResource(product.idImage)
            favoriteItemArrival.text = "Arrives in ${product.arrival.toString()} days"


        }
    }

}
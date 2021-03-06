package com.example.mercadolibreclonbedu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterProduct(
    private val context: Context,
    private val products: MutableList<Product>,
    private val clickListener: (Product) -> Unit): RecyclerView.Adapter<RecyclerAdapterProduct.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_product, parent, false))
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
        val productName = view.findViewById(R.id.nameListProduct) as TextView
        val price = view.findViewById(R.id.priceListProduct) as TextView
        val image = view.findViewById(R.id.imageListProduct) as ImageView
        val heartFav = view.findViewById(R.id.addFavoriteItemList) as ImageView

        //"atando" los datos a las Views
        fun bind(product: Product, context: Context){
            productName.text = product.name
            price.text = product.price
            image.setImageResource(product.idImage)
            heartFav.setOnClickListener{
                val intent = Intent(context, FavoritesActivity::class.java)
                intent.putExtra("Fav", product)
                context.startActivity(intent)
            }
        }
    }

}
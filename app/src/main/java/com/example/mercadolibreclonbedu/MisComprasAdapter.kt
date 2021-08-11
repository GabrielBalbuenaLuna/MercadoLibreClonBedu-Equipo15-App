package com.example.mercadolibreclonbedu

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MisComprasAdapter (val misCompraslistfa:List<MisComprasEntity>): RecyclerView.Adapter<MisComprasAdapter.MisComprasViewHolder>(){

    //Metodo que crea el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MisComprasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MisComprasViewHolder(layoutInflater.inflate(R.layout.list_item_mis_compras, parent, false))
    }

    //Titular de vista enlazada
    override fun onBindViewHolder(holder: MisComprasViewHolder, position: Int) {
        val ItemsViewModel = misCompraslistfa[position]
        holder.tvNombreProducto.text = ItemsViewModel.nombreProducto
        holder.tvEstatus.text = ItemsViewModel.statusProducto
        Picasso.get().load(ItemsViewModel.image).into(holder.ivImagenCompra);
    }

    //Metodo que retorna el tamaño de la lista
    override fun getItemCount(): Int = misCompraslistfa.size

    // Holds the views for adding it to image and text
    class MisComprasViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvEstatus: TextView = itemView.findViewById(R.id.tv_estatus)
        val tvNombreProducto: TextView = itemView.findViewById(R.id.tv_nombre_producto)
        val ivImagenCompra: ImageView = itemView.findViewById(R.id.iv_imagen_compra)
    }
}
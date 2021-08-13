package com.example.mercadolibreclonbedu

import android.os.Parcel
import android.os.Parcelable

class Product(
    val name: String,
    val price: String,
    val rating: Float,
    val arrival: Int,
    val idImage: Int,
    val setImages: ArrayList<String>?,
    val setSizes: ArrayList<String>,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readInt(),
        arrayListOf<String>().apply {
            parcel.readList(this, String::class.java.classLoader)
        },
        arrayListOf<String>().apply {
            parcel.readList(this, String::class.java.classLoader)
        },
    ) {
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(price)
        parcel.writeFloat(rating)
        parcel.writeInt(arrival)
        parcel.writeInt(idImage)
        parcel.writeList(setImages)
        parcel.writeList(setSizes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}



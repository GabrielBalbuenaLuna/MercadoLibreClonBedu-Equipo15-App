package com.example.mercadolibreclonbedu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FavoritesActivity : AppCompatActivity()  {
    private lateinit var cardFavorites: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        cardFavorites = findViewById(R.id.cardFavorites)
    }
}
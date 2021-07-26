package com.example.mercadolibreclonbedu
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ProductActivity : AppCompatActivity()  {

    private lateinit var buttonAdd: Button
    private lateinit var buttonMinus: Button

    private lateinit var quantityText: EditText
    private var quantityProduct = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        buttonAdd = findViewById(R.id.addProduct)
        buttonMinus = findViewById(R.id.minusProduct)
        quantityText = findViewById(R.id.quantityText)


        buttonAdd.setOnClickListener {
            quantityProduct++
            quantityText.setText(quantityProduct)
        }

        buttonMinus.setOnClickListener {
            quantityProduct--
            quantityText.setText(quantityProduct)
        }




    }
}
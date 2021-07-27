package com.example.mercadolibreclonbedu
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductActivity : AppCompatActivity()  {

    private lateinit var buttonAdd: Button
    private lateinit var buttonMinus: Button

    private lateinit var buttonGetBack: ImageView

    private lateinit var buttonSmallSize: Button
    private lateinit var buttonMediumSize: Button
    private lateinit var buttonLargeSize: Button

    private lateinit var quantityText: TextView
    private lateinit var sizeSpecifications: TextView
    private var quantityProduct = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        buttonGetBack = findViewById(R.id.getBackIcon)

        buttonAdd = findViewById(R.id.addProduct)
        buttonMinus = findViewById(R.id.minusProduct)
        quantityText = findViewById(R.id.quantityText)


        sizeSpecifications = findViewById(R.id.sizeSpecifications)

        buttonSmallSize = findViewById(R.id.sizeS)
        buttonMediumSize = findViewById(R.id.sizeM)
        buttonLargeSize = findViewById(R.id.sizeL)


        buttonAdd.setOnClickListener {
            quantityProduct++
            quantityText.text = quantityProduct.toString()
        }

        buttonMinus.setOnClickListener {
            quantityProduct--
            quantityText.text = quantityProduct.toString()
        }

        buttonSmallSize.setOnClickListener {
            buttonSmallSize.setBackgroundResource(R.drawable.rounded_button_white)
            buttonMediumSize.setBackgroundResource(R.drawable.rounded_deselect)
            buttonLargeSize.setBackgroundResource(R.drawable.rounded_deselect)
            sizeSpecifications.text = "Height: 30cm, Width: 20 cm, Heel: 5 cm"
        }

        buttonMediumSize.setOnClickListener {
            buttonMediumSize.setBackgroundResource(R.drawable.rounded_button_white)
            buttonSmallSize.setBackgroundResource(R.drawable.rounded_deselect)
            buttonLargeSize.setBackgroundResource(R.drawable.rounded_deselect)
            sizeSpecifications.text = "Height: 32cm, Width: 22 cm, Heel: 5 cm"
        }

        buttonLargeSize.setOnClickListener {
            buttonSmallSize.setBackgroundResource(R.drawable.rounded_deselect)
            buttonMediumSize.setBackgroundResource(R.drawable.rounded_deselect)
            buttonLargeSize.setBackgroundResource(R.drawable.rounded_button_white)
            sizeSpecifications.text = "Height: 34cm, Width: 24 cm, Heel: 5 cm"
        }

        buttonGetBack.setOnClickListener {
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }

    }
}
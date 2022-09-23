package com.example.dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.diceapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonD6 = findViewById<Button>(R.id.buttonD6)
        buttonD6.setOnClickListener {
            rolarDados(6)


        }
        val buttonD12 = findViewById<Button>(R.id.buttonD12)
        buttonD12.setOnClickListener {
            rolarDados12(12)
        }
        val buttonD20 = findViewById<Button>(R.id.buttonD20)
        buttonD20.setOnClickListener {
            rolarDados20(20)
        }


    }

    private fun rolarDados(lados: Int) {
        val rolagem = (1..lados).random()
        val textDados = findViewById<TextView>(R.id.textDados)

        textDados.text = rolagem.toString()
    }


    private fun rolarDados12(lados: Int) {
        val rolagem = (1..lados).random()
        val textDados = findViewById<TextView>(R.id.textDados)
        textDados.text = rolagem.toString()
    }

    private fun rolarDados20(lados: Int) {
        val rolagem = (1..lados).random()
        val textDados = findViewById<TextView>(R.id.textDados)
        textDados.text = rolagem.toString()
    }
}
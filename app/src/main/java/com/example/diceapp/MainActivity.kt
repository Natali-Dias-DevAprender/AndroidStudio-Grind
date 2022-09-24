package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //Aqui criamos as nossas referencias
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //Diz qual layout a nossa tela esta usando

        // O findViewById() nos possibilita encontrar uma view ,ou seja, encontrar  um componente atraves do id dela

        val buttonD6 = findViewById<Button>(R.id.buttonD6) //Rerefencia guardada dentro dos parenteses(buttonD6)! R =Resource
        buttonD6.setOnClickListener { //Aqui será possivel executar o botão
            rolarDados(6)
            //Nós podemos falar que quando fomos usar nosso setOnClickListener ,podemos chamar um metodo
            // e esse metodo vai ser responsavel por gerar os numeros aleatorios pra gente

        // Toast.makeText(context: this, text: "Botão clicado"),Toast.LENGHT_LONG).show() É possivel saber em qual contexto isso esta criado, apartir disso,
        // ele já cria uma mensagem flutuante e com durançao de botão clicado um pouco mais longa



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
        val textDados = findViewById<TextView>(R.id.textDados) //

        textDados.text = rolagem.toString()
    }


    private fun rolarDados12(lados: Int) {
        val rolagem = (1..lados).random() //Qunado cair aqui, vai gerar um numero aleatorio
        val textDados = findViewById<TextView>(R.id.textDados) //Aqui referenciamos o textDados aramazenando ele na variavel de baixo
        textDados.text = rolagem.toString()
    }

    private fun rolarDados20(lados: Int) {
        val rolagem = (1..lados).random()
        val textDados = findViewById<TextView>(R.id.textDados)
        textDados.text = rolagem.toString()
    }
}
package com.example.activitieseintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

         val buttonVoltar = findViewById<Button>(R.id.buttonVoltar)

         /*Abaixo não poderemos criar uma nova intent pra voltar pra nossa MainActivity,
          pq ela já esta sendo executada em background,e geraria telas infinitas,por isso ultilizaremos
        o "Finish" pra finalizar o processo e voltar pra nossa MainActivity*/

         buttonVoltar.setOnClickListener{
         finish()
    }




    }
}
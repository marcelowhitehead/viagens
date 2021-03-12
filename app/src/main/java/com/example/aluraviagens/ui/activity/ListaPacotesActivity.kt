package com.example.aluraviagens.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.aluraviagens.R
import com.example.aluraviagens.dao.PacoteDAO
import com.example.aluraviagens.model.Pacote
import com.example.aluraviagens.ui.adapter.ListaPacotesAdapter

class ListaPacotesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        val pacotes: List<Pacote> = PacoteDAO().lista() as List<Pacote>
        val listaDePacotes = findViewById<ListView>(R.id.lista_pacotes_listview)
        listaDePacotes.adapter = ListaPacotesAdapter(pacotes, this)
    }
}
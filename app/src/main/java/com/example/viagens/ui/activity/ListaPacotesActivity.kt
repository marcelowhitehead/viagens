package com.example.viagens.ui.activity

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.viagens.R
import com.example.viagens.dao.PacoteDAO
import com.example.viagens.model.Pacote
import com.example.viagens.ui.adapter.ListaPacotesAdapter

class ListaPacotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        configuraLista()
    }

    private fun configuraLista() {
        val pacotes: List<Pacote> = PacoteDAO().lista() as List<Pacote>
        val listaDePacotes = findViewById<ListView>(R.id.lista_pacotes_listview)
        listaDePacotes.adapter = ListaPacotesAdapter(pacotes, this)
    }
}
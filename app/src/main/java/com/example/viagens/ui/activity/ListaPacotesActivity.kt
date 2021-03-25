package com.example.viagens.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.viagens.R
import com.example.viagens.dao.PacoteDAO
import com.example.viagens.model.Pacote
import com.example.viagens.ui.activity.PacoteActivityConstantes.Companion.CHAVE_PACOTE
import com.example.viagens.ui.adapter.ListaPacotesAdapter


class ListaPacotesActivity : AppCompatActivity() {

    private var listaDePacote: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        title = "Pacotes"
        listaDePacote = findViewById(R.id.lista_pacotes_listview)

        configuraLista()
    }

    private fun configuraLista() {
        val pacotes = PacoteDAO().lista() as List<Pacote>
        listaDePacote?.adapter = ListaPacotesAdapter(pacotes, this)
        listaDePacote?.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id ->
            val pacoteClidado = pacotes.get(position)
            goToResumoPacote(pacoteClidado)
        }
    }

    private fun goToResumoPacote(pacoteClidado: Pacote) {
        startActivity(Intent(this, ResumoPacotesActivity::class.java)
                .putExtra(CHAVE_PACOTE, pacoteClidado))
    }
}

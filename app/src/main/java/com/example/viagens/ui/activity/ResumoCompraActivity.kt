package com.example.viagens.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.viagens.R
import com.example.viagens.model.Pacote
import com.example.viagens.ui.activity.PacoteActivityConstantes.Companion.CHAVE_PACOTE
import com.example.viagens.util.DataUtil
import com.example.viagens.util.DiasUtil
import com.example.viagens.util.MoedaUtil
import com.example.viagens.util.ResourceUtil
import java.math.BigDecimal

class ResumoCompraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_compra)

        setTitle("Resumo da compra")

        carregaPacoteRecebido()
    }

    private fun carregaPacoteRecebido() {
        val intent = getIntent()
        if (intent.hasExtra(CHAVE_PACOTE)) {
            val pacote = intent.getSerializableExtra(CHAVE_PACOTE) as Pacote
            inicializaCampos(pacote)
        }
    }

    private fun inicializaCampos(pacote: Pacote) {
        setImage(pacote)
        setLocal(pacote)
        setPrice(pacote)
        setDate(pacote)
    }

    private fun setDate(pacote : Pacote) {
        val data = findViewById<TextView>(R.id.resumo_compra_data)
        val dataFormatadaViagem = DataUtil.periodoEmTexto(pacote.dias)
        data.text = dataFormatadaViagem
    }

    private fun setPrice(pacote: Pacote) {
        val preco = findViewById<TextView>(R.id.resumo_compra_preco)
        preco.text = MoedaUtil.formataMoedaParaReal(pacote.preco)
    }

    private fun setImage(pacote: Pacote) {
        val imagem = findViewById<ImageView>(R.id.resumo_compra_imagem)
        val drawableImagemPacote = ResourceUtil.devolveDrawable(this, pacote)
        imagem.setImageDrawable(drawableImagemPacote)
    }

    private fun setLocal(pacote: Pacote) {
        val local = findViewById<TextView>(R.id.resumo_compra_local)
        local.text = pacote.local
    }
}
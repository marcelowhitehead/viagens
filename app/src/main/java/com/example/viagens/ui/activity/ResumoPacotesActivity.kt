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
import java.text.SimpleDateFormat
import java.util.*

class ResumoPacotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacotes)

        setTitle("Resumo do pacote")
        carregaPacoteRecebido()
    }

    private fun carregaPacoteRecebido() {
        val intent = getIntent()
        if (intent.hasExtra(CHAVE_PACOTE)) {
            val pacote = intent.getSerializableExtra(CHAVE_PACOTE) as Pacote
            inicializaCampos(pacote)
            configuraBotao(pacote)
        }
    }

    private fun configuraBotao(pacote: Pacote) {
        val botaoRealizaPagamento = findViewById<Button>(R.id.resumo_pacote_botao_pagamento)
        botaoRealizaPagamento.setOnClickListener(View.OnClickListener {
            goToPagamento(pacote)
        })
    }

    private fun goToPagamento(pacote: Pacote) {
        startActivity(Intent(this, PagamentoActivity::class.java)
                .putExtra(CHAVE_PACOTE, pacote))
    }

    private fun inicializaCampos(pacote: Pacote) {
        setImage(pacote)
        setLocal(pacote)
        setDays(pacote)
        setPrice(pacote)
        setDate(pacote)
    }

    private fun setDate(pacote : Pacote) {
        val data = findViewById<TextView>(R.id.resumo_pacote_data)
        val dataFormatadaViagem = DataUtil.periodoEmTexto(pacote.dias)
        data.text = dataFormatadaViagem
    }

    private fun setPrice(pacote: Pacote) {
        val preco = findViewById<TextView>(R.id.resumo_pacote_preco)
        preco.text = MoedaUtil.formataMoedaParaReal(pacote.preco)
    }

    private fun setDays(pacote: Pacote) {
        val dias = findViewById<TextView>(R.id.resumo_pacote_dias)
        dias.text = DiasUtil.formataEmTexto(pacote.dias)
    }

    private fun setImage(pacote: Pacote) {
        val imagem = findViewById<ImageView>(R.id.resumo_pacote_imagem)
        val drawableImagemPacote = ResourceUtil.devolveDrawable(this, pacote)
        imagem.setImageDrawable(drawableImagemPacote)
    }

    private fun setLocal(pacote: Pacote) {
        val local = findViewById<TextView>(R.id.resumo_pacote_local)
        local.text = pacote.local
    }
}
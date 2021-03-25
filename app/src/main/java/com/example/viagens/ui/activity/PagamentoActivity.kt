package com.example.viagens.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.viagens.R
import com.example.viagens.model.Pacote
import com.example.viagens.ui.activity.PacoteActivityConstantes.Companion.CHAVE_PACOTE
import com.example.viagens.util.MoedaUtil
import com.google.android.material.textfield.TextInputLayout
import java.math.BigDecimal

class PagamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

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

    private fun inicializaCampos(pacote: Pacote) {
        setPreco(pacote)
    }

    private fun configuraBotao(pacote: Pacote) {
        val botaoFinalizaPagamento = findViewById<Button>(R.id.pagamento_botao_finaliza_compra)
        botaoFinalizaPagamento.setOnClickListener(View.OnClickListener {
            goToResumoCompra(pacote)
        })
    }

    private fun goToResumoCompra(pacote: Pacote) {
        startActivity(Intent(this, ResumoCompraActivity::class.java)
                .putExtra(CHAVE_PACOTE, pacote))
    }

    private fun setPreco(pacote: Pacote) {
        val valor = findViewById<TextView>(R.id.pagamento_preco_pacote)
        valor.text = MoedaUtil.formataMoedaParaReal(pacote.preco)
    }
}



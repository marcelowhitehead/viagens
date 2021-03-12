package com.example.aluraviagens.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.aluraviagens.R
import com.example.aluraviagens.model.Pacote
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class ListaPacotesAdapter(val pacotes: List<Pacote>, val context: Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false)

        val pacote = pacotes.get(position)

        val local = viewCriada.findViewById<TextView>(R.id.item_pacote_local)
        local.text = pacote.local

        val imagem = viewCriada.findViewById<ImageView>(R.id.item_pacote_imagem)
        val resources = context.resources
        val idDoDrawable = resources.getIdentifier(pacote.imagem,
                "drawable",
                context.packageName)
        val drawableImagemPacote = resources.getDrawable(idDoDrawable)
        imagem.setImageDrawable(drawableImagemPacote)

        val dias = viewCriada.findViewById<TextView>(R.id.item_pacote_dias)
        val quantidadeDeDias: Int = pacote.dias
        var diasEmTexto: String = ""
        if (quantidadeDeDias > 1) diasEmTexto = "${quantidadeDeDias} dias"
        else diasEmTexto = "${quantidadeDeDias} dia"
        dias.text = diasEmTexto

        val preco = viewCriada.findViewById<TextView>(R.id.item_pacote_preco)
        val precoDoPacote: BigDecimal = pacote.preco
        val formatoBrasileiro = DecimalFormat.getCurrencyInstance(Locale("pt", "br"))
        val precoMoedaBrasileira = formatoBrasileiro.format(precoDoPacote)
        preco.text = precoMoedaBrasileira

        return viewCriada
    }

    override fun getItem(position: Int): Pacote {
        return pacotes.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return pacotes.size
    }

}

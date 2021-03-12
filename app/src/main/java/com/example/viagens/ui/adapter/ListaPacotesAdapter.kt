package com.example.viagens.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.viagens.R
import com.example.viagens.model.Pacote
import com.example.viagens.util.DiasUtil
import com.example.viagens.util.MoedaUtil
import com.example.viagens.util.ResourceUtil
import java.math.BigDecimal

class ListaPacotesAdapter(val pacotes: List<Pacote>, val context: Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false)

        val pacote = pacotes.get(position)

        setLocal(viewCriada, pacote)
        setImage(viewCriada, pacote)
        setDay(viewCriada, pacote)
        setPrice(viewCriada, pacote)
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

    private fun setPrice(viewCriada: View, pacote: Pacote) {
        val preco = viewCriada.findViewById<TextView>(R.id.item_pacote_preco)
        val precoDoPacote: BigDecimal = pacote.preco
        val precoMoedaBrasileira = MoedaUtil.Companion.formataMoedaParaReal(precoDoPacote)
        preco.text = precoMoedaBrasileira
    }

    private fun setDay(viewCriada: View, pacote: Pacote) {
        val dias = viewCriada.findViewById<TextView>(R.id.item_pacote_dias)
        var diasEmTexto: String = DiasUtil.Companion.formataEmTexto(pacote.dias)
        dias.text = diasEmTexto
    }

    private fun setImage(viewCriada: View, pacote: Pacote) {
        val imagem = viewCriada.findViewById<ImageView>(R.id.item_pacote_imagem)
        val drawableImagemPacote = ResourceUtil.Companion.
                devolveDrawable(context, pacote)
        imagem.setImageDrawable(drawableImagemPacote)
    }

    private fun setLocal(viewCriada: View, pacote: Pacote) {
        val local = viewCriada.findViewById<TextView>(R.id.item_pacote_local)
        local.text = pacote.local
    }

}

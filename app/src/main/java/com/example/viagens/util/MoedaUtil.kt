package com.example.viagens.util

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class MoedaUtil {

    companion object{
          fun formataMoedaParaReal(precoDoPacote: BigDecimal): String? {
            val formatoBrasileiro = DecimalFormat.getCurrencyInstance(
                Locale("pt", "br")
            )
            val precoMoedaBrasileira = formatoBrasileiro.format(precoDoPacote)
            return precoMoedaBrasileira
        }
    }
}
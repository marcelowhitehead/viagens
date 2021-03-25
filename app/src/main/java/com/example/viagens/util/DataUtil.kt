package com.example.viagens.util

import java.text.SimpleDateFormat
import java.util.*

class DataUtil {

    companion object{
         fun periodoEmTexto(dias: Int): String {
            val dataIda = Calendar.getInstance()
            val dataVolta = Calendar.getInstance()
            dataVolta.add(Calendar.DATE, dias)
            val formatoBrasileiro = SimpleDateFormat("dd/MM")
            val dataFormatadaIda = formatoBrasileiro.format(dataIda.time)
            val dataFormatadaVolta = formatoBrasileiro.format(dataVolta.time)
            val dataFormatadaViagem = dataFormatadaIda + " - " +
                    dataFormatadaVolta + " de " +
                    dataVolta.get(Calendar.YEAR)
            return dataFormatadaViagem
        }
    }

}
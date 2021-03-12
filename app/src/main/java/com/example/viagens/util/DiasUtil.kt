package com.example.viagens.util

class DiasUtil {

    companion object{
        fun formataEmTexto(quantidadeDeDias: Int): String {
            if (quantidadeDeDias > 1) return "${quantidadeDeDias} dias"
            else return "${quantidadeDeDias} dia"
        }
    }

}
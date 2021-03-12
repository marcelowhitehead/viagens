package com.example.viagens.model

import java.math.BigDecimal

class Pacote(internal val local: String,
             internal val imagem: String,
             internal val dias: Int,
             internal val preco: BigDecimal)
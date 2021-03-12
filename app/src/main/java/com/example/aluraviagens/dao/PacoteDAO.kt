package com.example.aluraviagens.dao

import com.example.aluraviagens.model.Pacote
import java.math.BigDecimal
import kotlin.collections.ArrayList

class PacoteDAO {

    fun lista(): List<Pacote?>? {
        return ArrayList(
            listOf(
                Pacote("São Paulo", "sao_paulo", 1, BigDecimal(243.99)),
                Pacote("Belo Horizonte", "belo_horizonte", 3, BigDecimal(421.50)),
                Pacote("Natal", "natal_rn", 4, BigDecimal(754.20)),
                Pacote("Foz do iguaçu", "foz_iguacu", 7, BigDecimal(890.52)),
                Pacote("Maragogi", "maragogi", 6, BigDecimal(532.55))
            )
        )
    }

}
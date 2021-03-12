package com.example.viagens.util

import android.content.Context
import android.graphics.drawable.Drawable
import com.example.viagens.model.Pacote

class ResourceUtil {

    companion object{
         fun devolveDrawable(context: Context, pacote: Pacote): Drawable? {
            val resources = context.resources
            val idDoDrawable = resources.getIdentifier(
                pacote.imagem,
                "drawable",
                context.packageName
            )
            val drawableImagemPacote = resources.getDrawable(idDoDrawable)
            return drawableImagemPacote
        }
    }
}
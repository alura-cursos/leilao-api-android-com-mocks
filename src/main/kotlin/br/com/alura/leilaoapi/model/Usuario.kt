package br.com.alura.leilaoapi.model

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass

@Entity
@IdClass(IdUsuario::class)
data class Usuario(
        @Id
        val id: Long = 0,
        @Id
        val nome: String = "")

private class IdUsuario : Serializable {
    val id: Long = 0
    val nome: String = ""
}

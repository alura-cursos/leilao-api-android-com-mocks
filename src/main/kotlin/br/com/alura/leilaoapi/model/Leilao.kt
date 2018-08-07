package br.com.alura.leilaoapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

private const val VALOR_PADRAO = 0.0

@Entity
data class Leilao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
        val id: Long = 0,
        val descricao: String = "",
        @OneToMany(cascade = [CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE])
        val lances: MutableList<Lance> = mutableListOf()) {

    fun maiorLance() = lances.maxBy { it.valor }?.valor ?: VALOR_PADRAO

    fun adiciona(lance: Lance) {
        lances.add(0, lance)
    }

    fun ultimoLance(): Lance {
        return lances.first()
    }

}
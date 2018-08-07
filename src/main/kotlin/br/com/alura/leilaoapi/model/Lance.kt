package br.com.alura.leilaoapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.*

@Entity
data class Lance(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
        val id: Long = 0,
        @ManyToOne
        @Cascade(CascadeType.ALL)
        val usuario: Usuario = Usuario(),
        val valor: Double = 0.0)
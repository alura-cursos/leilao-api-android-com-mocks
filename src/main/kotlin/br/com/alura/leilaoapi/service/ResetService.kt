package br.com.alura.leilaoapi.service

import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Service
class ResetService(
        private val em: EntityManager) {

    @Transactional
    fun limpaBancoDeDados() {
        val limpaTodasTabelas = "TRUNCATE SCHEMA PUBLIC RESTART IDENTITY " +
                "AND COMMIT NO CHECK"
        val query = em.createNativeQuery(limpaTodasTabelas)
        query.executeUpdate()
    }

}
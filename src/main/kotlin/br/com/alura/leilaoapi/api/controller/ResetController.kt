package br.com.alura.leilaoapi.api.controller

import br.com.alura.leilaoapi.service.ResetService
import org.springframework.context.annotation.Profile
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

private const val BANCO_LIMPADO_COM_SUCESSO = "Banco de dados limpado"

@Controller
@RequestMapping("reset")
@Profile(PERFIL_TESTE)
class ResetController(
        private val resetService: ResetService) {

    @GetMapping
    fun reset(): ResponseEntity<String> {
        resetService.limpaBancoDeDados()
        return ResponseEntity.ok(BANCO_LIMPADO_COM_SUCESSO)
    }

}
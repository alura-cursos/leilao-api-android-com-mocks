package br.com.alura.leilaoapi.api.controller

import br.com.alura.leilaoapi.model.Leilao
import br.com.alura.leilaoapi.service.LeilaoService
import org.springframework.context.annotation.Profile
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("leilao")
@Profile(PERFIL_TESTE)
class LeilaoTestController(
        private val service: LeilaoService) {

    @PostMapping
    @Profile(PERFIL_TESTE)
    fun novo(@RequestBody leilao: Leilao): ResponseEntity<Leilao> {
        val leilaoSalvo = service.salva(leilao)
        return ResponseEntity.ok(leilaoSalvo)
    }

}
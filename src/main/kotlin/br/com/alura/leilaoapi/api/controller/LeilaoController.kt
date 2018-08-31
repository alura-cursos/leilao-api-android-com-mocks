package br.com.alura.leilaoapi.api.controller

import br.com.alura.leilaoapi.exception.LanceMenorQueUltimoLanceException
import br.com.alura.leilaoapi.exception.MesmoUsuarioDoUltimoLance
import br.com.alura.leilaoapi.exception.UsuarioJaDeuCincoLances
import br.com.alura.leilaoapi.model.Lance
import br.com.alura.leilaoapi.model.Leilao
import br.com.alura.leilaoapi.service.LeilaoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@RestController
@RequestMapping("leilao")
class LeilaoController(
        private val service: LeilaoService) {

    @PutMapping("{id}/lance")
    fun propoeLance(@PathVariable("id") id: Long, @RequestBody lance: Lance): ResponseEntity<Any> {
        return try {
            val leilaoRetornado = service.buscaPorId(id).get()
            service.salvaNovoLance(lance, leilaoRetornado)
            ResponseEntity.ok(leilaoRetornado)
        } catch (e: Exception) {
            val mensagemDeErro = when (e) {
                is NoSuchElementException, is LanceMenorQueUltimoLanceException,
                is MesmoUsuarioDoUltimoLance, is UsuarioJaDeuCincoLances -> e.message
                else -> ERRO_GENERICO
            }
            ResponseEntity.badRequest().body(mensagemDeErro)
        }
    }

    @GetMapping
    fun todos(): ResponseEntity<List<Leilao>> {
        val todosLeiloes = service.todos()
        return ResponseEntity.ok(todosLeiloes)
    }

    @PostMapping("form")
    fun novo(leilao: Leilao): ModelAndView {
        ResponseEntity.ok(service.salva(leilao))
        return ModelAndView("redirect:/")
    }

}
package br.com.alura.leilaoapi.controller

import br.com.alura.leilaoapi.service.LeilaoService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class MainController(
        private val leilaoService: LeilaoService) {

    @ModelAttribute("leiloes")
    fun leiloes(): List<String> = {
        val todosLeiloes = leilaoService.todos()
        todosLeiloes.map { "${it.id} - ${it.descricao}" }
    }()

    @GetMapping
    fun index(): String {
        return "index"
    }

}
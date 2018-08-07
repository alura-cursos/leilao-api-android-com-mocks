package br.com.alura.leilaoapi.service

import br.com.alura.leilaoapi.exception.LanceMenorQueUltimoLanceException
import br.com.alura.leilaoapi.exception.MesmoUsuarioDoUltimoLance
import br.com.alura.leilaoapi.exception.UsuarioJaDeuCincoLances
import br.com.alura.leilaoapi.model.Lance
import br.com.alura.leilaoapi.model.Leilao
import br.com.alura.leilaoapi.repository.LeilaoRepository
import org.springframework.stereotype.Service
import java.util.*

private const val LIMITE_LANCES: Int = 4

@Service
class LeilaoService(
        val repository: LeilaoRepository) {

    fun todos(): List<Leilao> {
        Leilao()
        return repository.findAll().toList()
    }

    fun buscaPorId(id: Long): Optional<Leilao> {
        return repository.findById(id)
    }

    fun salvaNovoLance(lance: Lance, leilao: Leilao) {
        validaLance(leilao, lance)
        leilao.adiciona(lance)
        repository.save(leilao)
    }

    fun salva(leilao: Leilao): Leilao {
        return repository.save(leilao)
    }

    private fun validaLance(leilao: Leilao, lance: Lance) {
        if (leilao.lances.isNotEmpty()) {
            if (menorQueUltimoLance(lance, leilao))
                throw LanceMenorQueUltimoLanceException()
            if (mesmoUsuario(lance, leilao))
                throw MesmoUsuarioDoUltimoLance()
            if (temCincoLances(leilao, lance))
                throw UsuarioJaDeuCincoLances()
        }
    }

    private fun temCincoLances(leilao: Leilao, lance: Lance) =
            leilao.lances.count { it.usuario.id == lance.usuario.id } > LIMITE_LANCES

    private fun menorQueUltimoLance(lance: Lance, leilao: Leilao) =
            lance.valor < leilao.maiorLance()

    private fun mesmoUsuario(lance: Lance, leilao: Leilao) =
            lance.usuario == leilao.ultimoLance().usuario

}
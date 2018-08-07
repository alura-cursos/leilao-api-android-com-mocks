package br.com.alura.leilaoapi.exception

class MesmoUsuarioDoUltimoLance : RuntimeException() {
    override val message: String
        get() = "Mesmo usuário do último lance"
}

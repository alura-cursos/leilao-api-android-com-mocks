package br.com.alura.leilaoapi.exception

class UsuarioJaDeuCincoLances : RuntimeException() {
    override val message: String
        get() = "Usuário já deu cinco lances"
}

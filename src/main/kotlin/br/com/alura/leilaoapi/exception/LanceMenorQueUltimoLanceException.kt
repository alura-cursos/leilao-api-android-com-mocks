package br.com.alura.leilaoapi.exception

class LanceMenorQueUltimoLanceException : RuntimeException(){
    override val message: String
        get() = "Lance menor que o último lance"
}

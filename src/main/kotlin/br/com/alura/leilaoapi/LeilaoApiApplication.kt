package br.com.alura.leilaoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LeilaoApiApplication

fun main(args: Array<String>) {
    runApplication<LeilaoApiApplication>(*args)
}
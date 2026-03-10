package br.com.caethas.atto.atto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AttoApplication

fun main(args: Array<String>) {
    runApplication<AttoApplication>(*args)
}

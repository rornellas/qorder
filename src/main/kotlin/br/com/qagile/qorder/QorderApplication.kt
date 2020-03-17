package br.com.qagile.qorder.core.health

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QorderApplication

fun main(args: Array<String>) {
	runApplication<QorderApplication>(*args)
}

package br.com.qagile.qorder.core.health.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
class PingHandlerController {

    @GetMapping("/ping")
    fun health(): String {
        return "pong => qorder"
    }
}
package com.presbtrack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.presbtrack"])
class PresbtrackApplication

fun main(args: Array<String>) {
    runApplication<PresbtrackApplication>(*args)
}

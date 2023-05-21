package com.example.kotlinpersonservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinPersonServiceApplication

fun main(args: Array<String>) {
    runApplication<KotlinPersonServiceApplication>(*args)
}

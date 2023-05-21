package com.example.kotlinpersonservice.model.entity

import jakarta.persistence.*

@Entity
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(unique = true, nullable = false)
    var name: String?,
    @Column(unique = true, nullable = false)
    var email: String?

)
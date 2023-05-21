package com.example.kotlinpersonservice.repository

import com.example.kotlinpersonservice.model.entity.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Long> {
}
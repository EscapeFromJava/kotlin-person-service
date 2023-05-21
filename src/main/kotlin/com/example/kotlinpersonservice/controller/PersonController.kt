package com.example.kotlinpersonservice.controller

import com.example.kotlinpersonservice.model.dto.PersonDto
import com.example.kotlinpersonservice.repository.PersonRepository
import com.example.kotlinpersonservice.service.PersonService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/person")
class PersonController(
    private val personService: PersonService,
    private val personRepository: PersonRepository
) {

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable("id") id: Long): PersonDto {
        return personService.getPersonById(id);
    }

    @GetMapping("")
    fun getPeople(): List<PersonDto> {
        return personService.getPeople();
    }

    @PostMapping("")
    fun savePerson(@RequestBody person: PersonDto): String {
        return personService.savePerson(person);
    }

    @DeleteMapping("/{id}")
    fun deletePersonById(@PathVariable("id") id: Long): String {
        return personService.deletePersonById(id);
    }

    @PutMapping("/{id}")
    fun updatePersonById(@PathVariable("id") id: Long, @RequestBody person: PersonDto): String {
        return personService.updatePersonById(id, person);
    }

}
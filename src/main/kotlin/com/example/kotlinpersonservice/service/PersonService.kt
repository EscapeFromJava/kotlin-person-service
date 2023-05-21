package com.example.kotlinpersonservice.service

import com.example.kotlinpersonservice.model.dto.PersonDto
import com.example.kotlinpersonservice.model.entity.Person
import com.example.kotlinpersonservice.repository.PersonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonService(private val repository: PersonRepository) {

    @Transactional
    fun savePerson(dto: PersonDto): String {
        val person = Person(name = dto.name, email = dto.email)
        repository.save(person)
        return "Person saved successfully"
    }

    @Transactional(readOnly = true)
    fun getPersonById(id: Long): PersonDto {
        val personOptional = repository.findById(id)
        if (personOptional.isPresent) {
            val person: Person = personOptional.get();
            return PersonDto(person.name, person.email)
        }
        return PersonDto();
    }

    @Transactional(readOnly = true)
    fun getPeople(): List<PersonDto> {
        val people = repository.findAll()
        return people.map {
            PersonDto(it.name, it.email)
        }
    }

    @Transactional
    fun deletePersonById(id: Long): String {
        try {
            repository.deleteById(id)
            return "Person with id $id deleted successfully";
        } catch (e: Exception) {
            return "Person with id $id not found"
        }
    }

    @Transactional
    fun updatePersonById(id: Long, dto: PersonDto): String {
        return try {
            val optionalPerson = repository.findById(id)
            if (optionalPerson.isPresent) {
                val person = optionalPerson.get()
                person.name = dto.name
                person.email = dto.email
                repository.save(person)
                "Person with id $id updated successfully";
            } else {
                "Person with id $id not found"
            }
        } catch (e: Exception) {
            "Person with id $id not found"
        }
    }

}
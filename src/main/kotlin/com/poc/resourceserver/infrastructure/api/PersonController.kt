package com.poc.resourceserver.infrastructure.api

import com.poc.resourceserver.core.domain.model.Person
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/svc/resources/person")
class PersonController {

    @GetMapping
    fun getPersons() : ResponseEntity<List<Person>>{
        return ResponseEntity.ok(emptyList())
    }

    @GetMapping("/{id}")
    fun getPerson(@PathVariable id: String) : ResponseEntity<Person?>{
        return ResponseEntity.ok(null)
    }

    @PostMapping
    fun createPerson() : ResponseEntity<Person?>{
        return ResponseEntity.ok(null)
    }

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: String) : ResponseEntity<Person?>{
        return ResponseEntity.ok(null)
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: String) : ResponseEntity<Person?>{
        return ResponseEntity.ok(null)
    }
}
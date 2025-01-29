package com.poc.resourceserver.infrastructure.api

import com.poc.resourceserver.core.domain.model.Person
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/svc/resources/persons")
class PersonController(
    private val personAdapter: PersonAdapter,
) {

    @GetMapping
    fun getPersons() : ResponseEntity<List<PersonView>>{
        return ResponseEntity.ok(personAdapter.getAllPersons())
    }

    @GetMapping("/{id}")
    fun getPerson(@PathVariable id: String) : ResponseEntity<PersonView?>{
        return ResponseEntity.ok(personAdapter.getPersonById(id))
    }

    @PostMapping
    fun createPerson(@RequestBody request: PersonCreationRequest) : ResponseEntity<PersonView?>{
        return ResponseEntity.ok(personAdapter.createPerson(request))
    }

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: String, @RequestBody request: PersonEditionRequest) : ResponseEntity<PersonView?>{
        return ResponseEntity.ok(personAdapter.updatePerson(id,request))
    }

    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: String) : ResponseEntity<String>{
        personAdapter.deletePerson(id)
        return ResponseEntity.ok("Person with id: $id has been deleted !")
    }
}
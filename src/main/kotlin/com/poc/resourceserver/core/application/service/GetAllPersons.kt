package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.ports.output.Persons
import com.poc.resourceserver.core.domain.model.Person

class GetAllPersons(
    private val persons: Persons
){
    fun execute(): List<Person> {
        return persons.findAll()
    }
}
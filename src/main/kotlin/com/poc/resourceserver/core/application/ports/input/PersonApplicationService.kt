package com.poc.resourceserver.core.application.ports.input

import com.poc.resourceserver.core.application.command.CreatePersonCommand
import com.poc.resourceserver.core.application.command.DeletePersonCommand
import com.poc.resourceserver.core.application.command.UpdatePersonCommand
import com.poc.resourceserver.core.application.query.GetPersonByIdQuery
import com.poc.resourceserver.core.domain.model.Person

interface PersonApplicationService {
    fun getAllPersons(): List<Person>
    fun getPersonById(query: GetPersonByIdQuery): Person?
    fun createPerson(command: CreatePersonCommand): Person
    fun updatePerson(command: UpdatePersonCommand): Person
    fun deletePerson(command: DeletePersonCommand): Person
}
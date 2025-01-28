package com.poc.resourceserver.infrastructure.api

import com.poc.resourceserver.core.application.ports.input.PersonApplicationService
import com.poc.resourceserver.core.domain.model.Person
import org.springframework.stereotype.Component

@Component
class PersonAdapter(
    private val personApplicationService: PersonApplicationService
) {
    fun getAllPersons() : List<Person> {
        return emptyList()
    }

    fun getPersonById(id : String) : Person? {
        return null
    }

    fun createPerson(request: PersonCreationRequest) : PersonView {
        val command = request.toCommand()
        return PersonView.from(personApplicationService.createPerson(command))
    }

    fun updatePerson(person: Person) : Person {
        return person
    }

    fun deletePerson(id : String) : Person? {
        return null
    }
}
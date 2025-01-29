package com.poc.resourceserver.infrastructure.api

import com.poc.resourceserver.core.application.command.DeletePersonCommand
import com.poc.resourceserver.core.application.ports.input.PersonApplicationService
import com.poc.resourceserver.core.application.query.GetPersonByIdQuery
import com.poc.resourceserver.core.domain.model.Person
import org.springframework.stereotype.Component
import java.util.*

@Component
class PersonAdapter(
    private val personApplicationService: PersonApplicationService
) {
    fun getAllPersons() : List<PersonView> {
        return personApplicationService.getAllPersons().map { PersonView.from(it) }
    }

    fun getPersonById(id : String) : Person? {
        val query =  id.toQuery()
        return personApplicationService.getPersonById(query)
    }

    fun createPerson(request: PersonCreationRequest) : PersonView {
        val command = request.toCommand()
        return PersonView.from(personApplicationService.createPerson(command))
    }

    fun updatePerson(person: Person) : Person {
        return person
    }

    fun deletePerson(id : String) {
        if (getPersonById(id).exist()) {
            personApplicationService.deletePerson(id.toCommand())
        }
    }

    private fun String.toQuery() : GetPersonByIdQuery{
        return GetPersonByIdQuery(UUID.fromString(this))
    }

    private fun String.toCommand() : DeletePersonCommand{
        return DeletePersonCommand(UUID.fromString(this))
    }

    private fun Person?.exist() : Boolean {
        return this != null
    }
}


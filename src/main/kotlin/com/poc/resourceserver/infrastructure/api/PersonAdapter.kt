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

    fun getPersonById(id : String) : PersonView? {
        val query =  id.toQuery()
        return personApplicationService.getPersonById(query)?.let { PersonView.from(it) }
    }

    fun createPerson(request: PersonCreationRequest) : PersonView {
        val command = request.toCommand()
        return PersonView.from(personApplicationService.createPerson(command))
    }

    fun updatePerson(id: String, request: PersonEditionRequest) : PersonView? {
        if(getPersonById(id).exist()) {
            return personApplicationService.updatePerson(request.toCommand(id))?.let { PersonView.from(it) }
        }
        return null
    }

    fun deletePerson(id : String) {
        if(getPersonById(id).exist()) {
            personApplicationService.deletePerson(id.toCommand())
        }
    }

    private fun String.toQuery() : GetPersonByIdQuery{
        return GetPersonByIdQuery(UUID.fromString(this))
    }

    private fun String.toCommand() : DeletePersonCommand{
        return DeletePersonCommand(UUID.fromString(this))
    }

    private fun PersonView?.exist() : Boolean {
        return this != null
    }
}


package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.command.CreatePersonCommand
import com.poc.resourceserver.core.application.command.DeletePersonCommand
import com.poc.resourceserver.core.application.command.UpdatePersonCommand
import com.poc.resourceserver.core.application.ports.input.PersonApplicationService
import com.poc.resourceserver.core.domain.model.Person
import java.util.*

class PersonApplicationServiceImpl(
    private val createPerson: CreatePerson,
    private val updatePerson: UpdatePerson,
    private val deletePerson: DeletePerson,
    private val getAllPersons: GetAllPersons,
) : PersonApplicationService {
    override fun getAllPersons(): List<Person> {
        return getAllPersons.execute()
    }

    override fun getPersonById(id: UUID): Person {
        TODO("Not yet implemented")
    }

    override fun createPerson(command: CreatePersonCommand): Person {
        return createPerson.handle(command)
    }

    override fun updatePerson(command: UpdatePersonCommand): Person {
        return updatePerson.handle(command)
    }

    override fun deletePerson(command: DeletePersonCommand): Person {
        return deletePerson.handle(command)
    }
}
package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.command.CreatePersonCommand
import com.poc.resourceserver.core.application.ports.output.Persons
import com.poc.resourceserver.core.domain.model.Person

class CreatePerson(
    private val persons: Persons
): AbstractCommandHandler<CreatePersonCommand, Person>() {
    override fun execute(command: CreatePersonCommand): Person {
        val person = command.toPerson()
        return persons.save(person)
    }
}
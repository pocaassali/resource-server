package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.command.UpdatePersonCommand
import com.poc.resourceserver.core.application.ports.output.Persons
import com.poc.resourceserver.core.domain.model.Person

class UpdatePerson(
    private val persons: Persons,
) : AbstractCommandHandler<UpdatePersonCommand, Person?>() {
    override fun execute(command: UpdatePersonCommand): Person? {
        return persons.update(command.toPerson())
    }
}
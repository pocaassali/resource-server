package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.command.DeletePersonCommand
import com.poc.resourceserver.core.application.command.UpdatePersonCommand
import com.poc.resourceserver.core.application.ports.output.Persons
import com.poc.resourceserver.core.domain.model.Person

class DeletePerson(
    private val persons: Persons
) : AbstractCommandHandler<DeletePersonCommand, Unit>() {
    override fun execute(command: DeletePersonCommand) {
        persons.delete(command.id)
    }
}
package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.command.DeletePersonCommand
import com.poc.resourceserver.core.application.command.UpdatePersonCommand
import com.poc.resourceserver.core.domain.model.Person

class DeletePerson : AbstractCommandHandler<DeletePersonCommand, Person>() {
    override fun execute(command: DeletePersonCommand): Person {
        TODO("Not yet implemented")
    }
}
package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.command.UpdatePersonCommand
import com.poc.resourceserver.core.domain.model.Person

class UpdatePerson : AbstractCommandHandler<UpdatePersonCommand, Person>() {
    override fun execute(command: UpdatePersonCommand): Person {
        TODO("Not yet implemented")
    }
}
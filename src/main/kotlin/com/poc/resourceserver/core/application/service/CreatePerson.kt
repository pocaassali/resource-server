package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.command.CreatePersonCommand
import com.poc.resourceserver.core.domain.model.Person

class CreatePerson : AbstractCommandHandler<CreatePersonCommand, Person>() {
    override fun execute(command: CreatePersonCommand): Person {
        TODO("Not yet implemented")
    }
}
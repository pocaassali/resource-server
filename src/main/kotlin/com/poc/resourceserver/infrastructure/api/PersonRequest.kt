package com.poc.resourceserver.infrastructure.api

import com.poc.resourceserver.core.application.command.CreatePersonCommand
import com.poc.resourceserver.core.domain.valueobject.Age
import com.poc.resourceserver.core.domain.valueobject.Gender
import com.poc.resourceserver.core.domain.valueobject.Hobby
import com.poc.resourceserver.core.domain.valueobject.Name
import java.util.*

data class PersonCreationRequest(
    val id : String,
    val name: String,
    val age: Int,
    val gender: String,
    val hobbies : Set<String>
){
    fun toCommand() : CreatePersonCommand{
        return CreatePersonCommand(
            id = UUID.fromString(id),
            name = Name(name),
            age = Age(age),
            gender = Gender.valueOf(gender),
            hobbies = hobbies.map { Hobby(it) }.toSet()
        )
    }
}
package com.poc.resourceserver.core.application.command

import com.poc.resourceserver.core.domain.model.Person
import com.poc.resourceserver.core.domain.valueobject.Age
import com.poc.resourceserver.core.domain.valueobject.Gender
import com.poc.resourceserver.core.domain.valueobject.Hobby
import com.poc.resourceserver.core.domain.valueobject.Name
import java.util.*

data class UpdatePersonCommand(
    val id : UUID,
    val name: Name,
    val age: Age,
    val gender: Gender,
    val hobbies: Set<Hobby>,
){
    fun toPerson(): Person {
        return Person(
            id = id,
            name = name,
            age = age,
            gender = gender,
            hobbies = hobbies,
        )
    }
}

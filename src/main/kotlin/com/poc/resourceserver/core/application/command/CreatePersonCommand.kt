package com.poc.resourceserver.core.application.command

import com.poc.resourceserver.core.domain.valueobject.Age
import com.poc.resourceserver.core.domain.valueobject.Gender
import com.poc.resourceserver.core.domain.valueobject.Hobby
import com.poc.resourceserver.core.domain.valueobject.Name
import java.util.*

data class CreatePersonCommand(
    val id : UUID,
    val name: Name,
    val age: Age,
    val gender: Gender,
    val hobbies: Set<Hobby>,
)

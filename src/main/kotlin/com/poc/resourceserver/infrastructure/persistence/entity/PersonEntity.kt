package com.poc.resourceserver.infrastructure.persistence.entity

import com.poc.resourceserver.core.domain.model.Person
import com.poc.resourceserver.core.domain.valueobject.Age
import com.poc.resourceserver.core.domain.valueobject.Gender
import com.poc.resourceserver.core.domain.valueobject.Hobby
import com.poc.resourceserver.core.domain.valueobject.Name
import java.util.*

data class PersonEntity(
    val id : String,
    val name: String,
    val age: Int,
    val gender: String,
    val hobbies : Set<String>
){
    fun toPerson() : Person{
        return Person(
            id = UUID.fromString(id),
            name = Name(name),
            age = Age(age),
            gender = Gender.valueOf(gender),
            hobbies = hobbies.map {Hobby(it)}.toSet()
        )
    }

    companion object{
        fun from(person: Person): PersonEntity{
            return PersonEntity(
                id = person.id.toString(),
                name = person.name.value,
                age = person.age.value,
                gender = person.gender.name,
                hobbies = person.hobbies.map { "$it" }.toSet()
            )
        }
    }
}

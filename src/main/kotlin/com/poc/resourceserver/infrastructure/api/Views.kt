package com.poc.resourceserver.infrastructure.api

import com.poc.resourceserver.core.domain.model.Person

data class PersonView(
    val id : String,
    val name: String,
    val age: Int,
    val gender: String,
    val hobbies : Set<String>
){

    companion object{
        fun from(person: Person): PersonView{
            return PersonView(
                id = person.id.toString(),
                name = person.name.value,
                age = person.age.value,
                gender = person.gender.name,
                hobbies = person.hobbies.map { "$it" }.toSet()
            )
        }
    }
}
package com.poc.resourceserver.core.domain.model

import java.util.UUID

data class Person(
    val id : UUID,
    val name: String,
    val age: Int,
    val gender: Gender,
    val hobbies : Set<String>
)


enum class Gender {
    MALE, FEMALE, OTHER
}
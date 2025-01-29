package com.poc.resourceserver.core.application.ports.output

import com.poc.resourceserver.core.domain.model.Person
import java.util.UUID

interface Persons {
    fun save(person: Person): Person
    fun delete(id: UUID)
    fun findById(id: UUID): Person?
    fun findAll(): List<Person>
    fun update(id: Long, entity: Person): Person?
}
package com.poc.resourceserver.core.application.ports.output

import com.poc.resourceserver.core.domain.model.Person

interface Persons {
    fun save(person: Person): Person
    fun delete(id: Long)
    fun findById(id: Long): Person?
    fun findAll(): List<Person>
    fun update(id: Long, entity: Person): Person?
}
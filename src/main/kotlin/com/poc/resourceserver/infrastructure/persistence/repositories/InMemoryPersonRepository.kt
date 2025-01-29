package com.poc.resourceserver.infrastructure.persistence.repositories

import com.poc.resourceserver.core.application.ports.output.Persons
import com.poc.resourceserver.core.domain.model.Person
import com.poc.resourceserver.infrastructure.persistence.entity.PersonEntity
import org.springframework.stereotype.Repository

@Repository
class InMemoryPersonRepository : Persons {
    private val persons: MutableMap<Long, PersonEntity> = mutableMapOf(
        Pair(1L,PersonEntity("474dcd70-73e3-461d-9772-f2f0fbaeafff","Alice",51,"FEMALE", setOf("movies"))),
        Pair(2L,PersonEntity("fb0d33cd-5d2a-4afd-97e5-8526784230b4","Bob",30,"MALE", setOf("IT","movies"))),
    )

    override fun save(person: Person): Person {
        val id = (persons.size+1).toLong()
        persons[id] = PersonEntity.from(person)
        return persons[id]?.toPerson() ?: person
    }

    override fun delete(id: Long) {
        persons.remove(id)
        return
    }

    override fun findById(id: Long): Person? {
        return persons[id]?.toPerson()
    }

    override fun findAll(): List<Person> {
        return persons.map { it.value.toPerson() }
    }

    override fun update(id: Long, entity: Person): Person? {
        persons[id] = PersonEntity.from(entity)
        return persons[id]?.toPerson()
    }
}
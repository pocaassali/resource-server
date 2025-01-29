package com.poc.resourceserver.config

import com.poc.resourceserver.core.application.ports.input.PersonApplicationService
import com.poc.resourceserver.core.application.ports.output.Persons
import com.poc.resourceserver.core.application.service.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoreConfig {
    @Bean
    fun personApplicationService(
        createPerson: CreatePerson,
        updatePerson: UpdatePerson,
        deletePerson: DeletePerson,
        getAllPersons: GetAllPersons,
        getPersonById: GetPersonById,
    ) = PersonApplicationServiceImpl(
        createPerson = createPerson,
        updatePerson = updatePerson,
        deletePerson = deletePerson,
        getAllPersons = getAllPersons,
        getPersonById = getPersonById
    )

    @Bean
    fun createPerson(
        persons: Persons
    ) = CreatePerson(persons = persons)

    @Bean
    fun updatePerson() = UpdatePerson()

    @Bean
    fun deletePerson() = DeletePerson()

    @Bean
    fun getAllPersons(
        persons: Persons
    ) = GetAllPersons(persons = persons)

    @Bean
    fun getPersonById(persons: Persons) = GetPersonById(persons = persons)

}
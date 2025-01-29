package com.poc.resourceserver.config

import com.poc.resourceserver.core.application.ports.output.Persons
import com.poc.resourceserver.core.application.service.*
import org.springframework.cglib.proxy.Mixin.createBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoreConfig {
    @Bean
    fun personApplicationService(
        createPerson: CreatePerson,
        updatePerson: UpdatePerson,
        deletePerson: DeletePerson,
        getAllPersons: GetAllPersons
    ) = PersonApplicationServiceImpl(
        createPerson = createPerson,
        updatePerson = updatePerson,
        deletePerson = deletePerson,
        getAllPersons = getAllPersons
    )

    @Bean
    fun createPerson() = CreatePerson()

    @Bean
    fun updatePerson() = UpdatePerson()

    @Bean
    fun deletePerson() = DeletePerson()

    @Bean
    fun getAllPersons(
        persons: Persons
    ) = GetAllPersons(persons = persons)

}
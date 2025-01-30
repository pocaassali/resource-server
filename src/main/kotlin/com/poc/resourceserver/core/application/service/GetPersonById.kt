package com.poc.resourceserver.core.application.service

import com.poc.resourceserver.core.application.ports.output.Persons
import com.poc.resourceserver.core.application.query.GetPersonByIdQuery
import com.poc.resourceserver.core.domain.model.Person


class GetPersonById(
    private val persons: Persons
) : AbstractQueryHandler<GetPersonByIdQuery, Person?>(){

    override fun execute(query: GetPersonByIdQuery): Person? {
        return persons.findById(query.id)
    }
}
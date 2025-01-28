package com.poc.resourceserver.core.application.service

abstract class AbstractQueryHandler<Q,R> {
    protected abstract fun execute(query: Q?): R

    fun handle(query: Q? = null): R {
        return execute(query)
    }
}
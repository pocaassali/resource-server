package com.poc.resourceserver.infrastructure.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/svc/resources/person")
class PersonController {

    @GetMapping
    fun greeting() = "Hello World"
}
package com.poc.resourceserver.config

import com.poc.resourceserver.core.application.service.PersonApplicationServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CoreConfig {
    @Bean
    fun personApplicationService() = PersonApplicationServiceImpl()
}
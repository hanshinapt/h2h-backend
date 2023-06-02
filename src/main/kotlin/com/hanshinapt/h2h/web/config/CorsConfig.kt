package com.hanshinapt.h2h.web.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer

/**
 * @author sangbeenmoon
 */
@Configuration
@EnableWebFlux
class CorsConfig : WebFluxConfigurer {

    override fun addCorsMappings(registry: CorsRegistry)
    {
        registry.addMapping("/**")
            .allowedOrigins("*") // any host or put domain(s) here
            .allowedMethods("GET, POST") // put the http verbs you want allow
            .allowedHeaders("Authorization") // put the http headers you want allow
    }
}

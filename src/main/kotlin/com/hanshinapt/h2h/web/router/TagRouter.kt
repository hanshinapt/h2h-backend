package com.hanshinapt.h2h.web.router

import com.hanshinapt.h2h.service.TagService
import com.hanshinapt.h2h.service.repository.mongo.document.Tag
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

/**
 * @author sangbeenmoon
 */
@Configuration
    @Bean("tagRoute")
    fun route() = router {
        GET("/api/v1/tags") { ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(tagService.get(), Tag::class.java) }
    }
}

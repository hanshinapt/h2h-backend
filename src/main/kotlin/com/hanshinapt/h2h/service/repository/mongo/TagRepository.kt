package com.hanshinapt.h2h.service.repository.mongo

import com.hanshinapt.h2h.service.repository.mongo.document.Tag
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

/**
 * @author sangbeenmoon
 */
@Repository
class TagRepository(private val mongoTemplate: ReactiveMongoTemplate) {

    fun findAll() : Flux<Tag> {
        return mongoTemplate.findAll(Tag::class.java)
    }
}

package com.hanshinapt.h2h.service.repository.mongo

import com.hanshinapt.h2h.service.repository.mongo.document.Deck
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

/**
 * @author sangbeenmoon
 */
@Repository
class DeckRepository(private val mongoTemplate: ReactiveMongoTemplate) {

    fun find(limit: Int): Flux<Deck> {
//        return mongoTemplate.find(Query().with(Sort.sort()).limit(limit), Deck::class.java)
        return Flux.empty()
    }
}

package com.hanshinapt.h2h.service.repository.mongo

import com.hanshinapt.h2h.service.repository.mongo.document.Deck
import org.springframework.data.domain.Sort
<<<<<<< HEAD
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
=======
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
>>>>>>> 79454a907eb1553f78d7fdac1b54eb02056a6f44

/**
 * @author sangbeenmoon
 */
@Repository
class DeckRepository(private val mongoTemplate: ReactiveMongoTemplate) {

    fun findOrderByPlayedCount(limit: Int): Flux<Deck> {
        return mongoTemplate.find(Query().with(Sort.by(Sort.Direction.DESC, "playedCount")).limit(limit), Deck::class.java)
    }

    fun findByTagId(tagId: String): Flux<Deck> {
        return mongoTemplate.find(Query.query(Criteria.where("tags").`in`(tagId)), Deck::class.java)
    }

    fun findById(id: String): Mono<Deck> {
        return mongoTemplate.findById(id, Deck::class.java)
    }

    fun updatePlayedCount(id: String): Mono<Deck> {
        return mongoTemplate.findAndModify(
            Query.query(Criteria.where("_id").`is`(id)),
            Update().inc("playedCount", 1),
            FindAndModifyOptions.options().returnNew(true), Deck::class.java
        )
    }
}

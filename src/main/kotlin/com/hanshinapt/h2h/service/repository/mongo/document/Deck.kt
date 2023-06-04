package com.hanshinapt.h2h.service.repository.mongo.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * @author sangbeenmoon
 */
@Document(collection = "deck")
data class Deck(
    @Id
    val id: String = "",
    val title: String = "",
    val description: String = "",
    @Field("tags")
    val tagIds: List<String> = emptyList(),
    val imageUrl: String = "",
    val questions: List<Question> = emptyList(),
    @CreatedDate
    val createdAt: String = "",
    @CreatedBy
    val createdBy: String = "",
    val playedCount: Int = 0
)

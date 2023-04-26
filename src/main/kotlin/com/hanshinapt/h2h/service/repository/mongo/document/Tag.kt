package com.hanshinapt.h2h.service.repository.mongo.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author sangbeenmoon
 */
@Document("tag")
data class Tag(
    @Id
    val id: ObjectId = ObjectId(),
    val name: String = ""
)

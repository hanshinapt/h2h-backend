package com.hanshinapt.h2h.service.repository.mongo.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

/**
 * @author sangbeenmoon
 */
data class Question(
    val content: String = ""
)

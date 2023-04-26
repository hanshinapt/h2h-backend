package com.hanshinapt.h2h.service

import com.hanshinapt.h2h.service.repository.mongo.TagRepository
import com.hanshinapt.h2h.service.repository.mongo.document.Tag
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

/**
 * @author sangbeenmoon
 */
@Service
class TagService(private val tagRepository: TagRepository) {

    fun get(): Flux<Tag> {
        return tagRepository.findAll()
    }
}

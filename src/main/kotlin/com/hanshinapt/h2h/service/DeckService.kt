package com.hanshinapt.h2h.service

import com.hanshinapt.h2h.service.repository.mongo.DeckRepository
import com.hanshinapt.h2h.service.repository.mongo.document.Deck
import com.hanshinapt.h2h.service.repository.mongo.document.SortingType
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author sangbeenmoon
 */
@Service
class DeckService(private val deckRepository: DeckRepository) {

    fun get(count: String, sortingType: String, tagId: String): Flux<Deck> {
        return if (tagId.isNotBlank()) {
            getByTagId(tagId)
        } else {
            get(count.toInt(), sortingType)
        }
    }

    fun get(count: Int, sortingType: String): Flux<Deck> {
        return when (SortingType.resolve(sortingType)) {
            SortingType.MOST_PLAYED -> deckRepository.findOrderByPlayedCount(count)
            else -> Flux.error(RuntimeException("Unknown sorting type"))
        }
    }

    fun getByTagId(tagId: String): Flux<Deck> {
        return deckRepository.findByTagId(tagId)
    }

    fun getByDeckId(deckId: String): Mono<Deck> {
        return deckRepository.findById(deckId)
    }

    fun play(deckId: String): Mono<Deck> {
        return deckRepository.updatePlayedCount(deckId)
    }

}

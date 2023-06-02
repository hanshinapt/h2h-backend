package com.hanshinapt.h2h.web.router

import com.hanshinapt.h2h.service.DeckService
import com.hanshinapt.h2h.service.repository.mongo.document.Deck
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

/**
 * @author sangbeenmoon
 */
@CrossOrigin
@Configuration
class DeckRouter(private val deckService: DeckService) {


    @Bean("deckRoute")
    fun route() = router {
        listOf(
            GET("/api/v1/decks") { serverRequest ->
                ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                        deckService.get(serverRequest.queryParam("count").orElseGet { "" },
                            serverRequest.queryParam("sort").orElseGet { "" },
                            serverRequest.queryParam("tag").orElseGet { "" }),
                        Deck::class.java
                    )
            },
            GET("/api/v1/decks/{deckId}") { serverRequest ->
                ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                        deckService.getByDeckId(serverRequest.pathVariable("deckId")), Deck::class.java
                    )
            },
            POST("/api/v1/decks/{deckId}/play") { serverRequest ->
                ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                        deckService.play(serverRequest.pathVariable("deckId")), Deck::class.java
                    )
            }
        )
    }
}

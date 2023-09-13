package no.omegapoint.kotlindemo.webclient

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

@Service
class RockPaperScissorWebClient(
    @Value("\${team}") private val teamName: String,
    @Value("\${address}") private val address: String
) {
    private val client = WebClient.builder().build()

    fun queueToGame(sign: String) { client.get().uri(uri(sign)).retrieve().bodyToMono<Unit>().subscribe() }

    private fun uri(sign: String) =
        UriComponentsBuilder.newInstance()
            .scheme("http").host(address).port(8081).path("queueGame")
            .queryParams(mapOf("teamName" to teamName, "sign" to sign))
            .build()

    private fun UriBuilder.queryParams(params: Map<String, String>) = apply {
        params.entries.forEach { queryParam(it.key, it.value) }
    }
}
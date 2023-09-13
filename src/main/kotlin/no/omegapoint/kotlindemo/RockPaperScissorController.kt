package no.omegapoint.kotlindemo

import no.omegapoint.kotlindemo.webclient.RockPaperScissorWebClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("rps")
class RockPaperScissorController(
    private val rpsWebClient: RockPaperScissorWebClient,
    private val matchStatisticRepository: MatchStatisticRepository
) {

    @GetMapping("cheater")
    fun playCheater(sign: String) = when (sign) {
        "rock" -> "paper"
        "paper" -> "scissor"
        "scissor" -> "rock"
        else -> throw RuntimeException("Unknown sign $sign")
    }

    @GetMapping("play")
    fun play() {
        rpsWebClient.queueToGame("rock")
    }

    @GetMapping("winner")
    fun winner() {
        println(matchStatisticRepository.countByWinner("placeholder"))
    }

    @GetMapping("loser")
    fun loser() {
        println(matchStatisticRepository.countByLoser("placeholder"))
    }
}
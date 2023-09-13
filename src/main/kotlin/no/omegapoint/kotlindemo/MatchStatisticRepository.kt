package no.omegapoint.kotlindemo

import no.omegapoint.kotlindemo.statistics.MatchStatistic
import org.springframework.data.jpa.repository.JpaRepository

interface MatchStatisticRepository: JpaRepository<MatchStatistic, Long> {

    fun countByWinner(winner: String): Int
    fun countByLoser(loser: String): Int
}
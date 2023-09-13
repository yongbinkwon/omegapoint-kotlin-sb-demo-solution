package no.omegapoint.kotlindemo.statistics

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "MatchStatistic")
class MatchStatistic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null,

    @Column
    private val winner: String? = null,

    @Column
    private val loser: String? = null,

    @Column(nullable = false)
    private val matchDate: LocalDateTime = LocalDateTime.now()
)
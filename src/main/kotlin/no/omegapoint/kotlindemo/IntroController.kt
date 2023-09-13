package no.omegapoint.kotlindemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("omegapoint")
class IntroController {
    @GetMapping("best")
    fun theBest() = "bin"

    @GetMapping("worst")
    fun theWorst() = "tom henrik"
}
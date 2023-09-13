package no.omegapoint.kotlindemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("omegapoint")
class Omegapoint(
    private val hiringManager: HiringManager
) {
    @GetMapping("hire")
    fun hire(name: String): String {
        return hiringManager.hire(name)
    }
}
package no.omegapoint.kotlindemo

import org.springframework.stereotype.Service

@Service
class HiringManager {
    fun hire(name: String): String {
        if (name == "bin") return "you're hired!"
        else return "meh"
    }
}
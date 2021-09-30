package com.justai.jaicf.template.scenario

import com.justai.jaicf.activator.caila.caila
import com.justai.jaicf.builder.Scenario

val mainScenario = Scenario {
state("changeView") {
            activators {
                intent("changeView")
            }
            action {
                reactions.say("Перехожу..." )
                var slot = ""
                activator.caila?.run {slot = slots["views"].toString()}
                reactions.aimybox?.response?.action = "changeView"
                reactions.aimybox?.response?.intent = slot

            }
        }

    fallback {
        reactions.sayRandom(
            "Sorry, I didn't get that...",
            "Sorry, could you repeat please?"
        )
    }
}

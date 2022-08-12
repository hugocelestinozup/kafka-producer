package br.com.zup.controller

import br.com.zup.api.PersonApi
import br.com.zup.controller.translator.toPersonDomain
import br.com.zup.request.PersonRequest
import br.com.zup.usecase.SendPersonDataUseCase
import org.slf4j.LoggerFactory
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
class PersonController(private val sendPersonDataUseCase: SendPersonDataUseCase) : PersonApi {

    private val logger = LoggerFactory.getLogger(PersonController::class.java)

    override fun sendMessage(person: PersonRequest) {
        logger.debug("[START] Sending person data: ${person.email}")

        val personDomain = person.toPersonDomain()
        sendPersonDataUseCase.execute(personDomain)

        logger.debug("[FINISH] Sending person data: ${person.email}")
    }
}
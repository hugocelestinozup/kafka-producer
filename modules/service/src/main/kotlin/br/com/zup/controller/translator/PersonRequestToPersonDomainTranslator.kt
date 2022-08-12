package br.com.zup.controller.translator

import br.com.zup.domain.PersonDomain
import br.com.zup.request.PersonRequest

fun PersonRequest.toPersonDomain() = PersonDomain(
    name = this.name,
    email = this.email
)
package br.com.zup.gateway

interface GetEmailValidationGateway {
    fun execute(email: String): Boolean
}
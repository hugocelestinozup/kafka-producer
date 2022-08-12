package br.com.zup.api

import br.com.zup.request.PersonRequest
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import javax.validation.Valid

@RequestMapping("/v1/send")
@Api(tags = ["Person"], value = "Endpoints to send person data")
interface PersonApi {

    @ApiOperation(value = "Sends person data to kafka", notes = "Sends person data to kafka")
    @ApiResponses(
        value = [
            ApiResponse(code = 201, message = "Created"),
            ApiResponse(code = 400, message = "Bad Request"),
            ApiResponse(code = 404, message = "Not Found"),
            ApiResponse(code = 500, message = "Internal Server Error")
        ]
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun sendMessage(@Valid @RequestBody person: PersonRequest)
}
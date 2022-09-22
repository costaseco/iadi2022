package pt.unl.fct.di.iadi.iadi2022lab1.presentation

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController : HelloAPI {

    override fun helloWorld():greetingResponse = greetingResponse("Hello! World!")

    override fun sayHello(@RequestBody greeting: greetingRequest): greetingResponse = greetingResponse("Hello, ${greeting.name}")
}
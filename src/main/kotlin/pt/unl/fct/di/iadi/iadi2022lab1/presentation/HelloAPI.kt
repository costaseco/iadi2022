package pt.unl.fct.di.iadi.iadi2022lab1.presentation

import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
interface HelloAPI {

    @GetMapping("helloworld")
    fun helloWorld(): greetingResponse

    @PostMapping("hello")
    fun sayHello(@RequestBody greeting:greetingRequest): greetingResponse
}

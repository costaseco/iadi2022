package pt.unl.fct.di.iadi.iadi2022lab1.presentation

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
interface HelloAPI {

    @GetMapping("helloworld")
    fun helloWorld():String

    @PostMapping("hello")
    fun sayHello(@RequestBody name:greetingRequest):String
}

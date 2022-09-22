package pt.unl.fct.di.iadi.iadi2022lab1.presentation

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class HelloController {

    @GetMapping("helloworld")
    fun helloWorld() = "Hello! World!"

    @PostMapping("hello")
    fun sayHello(@RequestBody name:String) = "Hello, $name"
}
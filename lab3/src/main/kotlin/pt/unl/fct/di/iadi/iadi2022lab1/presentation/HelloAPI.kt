package pt.unl.fct.di.iadi.iadi2022lab1.presentation

import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
interface HelloAPI {

    @GetMapping("helloworld")
    fun helloWorld(): GreetingResponse

    @PostMapping("hello")
    fun sayHello(@RequestBody greeting:GreetingRequest): GreetingResponse

    @PostMapping("users")
    fun addUser(@RequestBody name:AddUserRequest)
}

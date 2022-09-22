package pt.unl.fct.di.iadi.iadi2022lab1.presentation

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import pt.unl.fct.di.iadi.iadi2022lab1.application.GreetingApplication
import pt.unl.fct.di.iadi.iadi2022lab1.service.UserService

@RestController
class HelloController(val app: GreetingApplication, val users:UserService) : HelloAPI {

    override fun helloWorld():GreetingResponse =
        GreetingResponse(app.generalSalut())

    override fun sayHello(@RequestBody greeting: GreetingRequest): GreetingResponse =
        GreetingResponse(app.personalSalut(greeting.name))

    override fun addUser(@RequestBody register: AddUserRequest) {
        users.addUser(register.name)
    }
}
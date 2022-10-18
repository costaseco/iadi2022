package pt.unl.fct.di.iadi.iadi2022lab1.application

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.iadi2022lab1.service.UserService

@Service
class GreetingApplication(val users: UserService) {

    fun generalSalut() = "Hello, World!"

    fun personalSalut(name:String) = if (users.userExists(name)) "Hello, ${name}!" else "Hello, stranger!"

}
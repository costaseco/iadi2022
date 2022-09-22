package pt.unl.fct.di.iadi.iadi2022lab1.presentation

import org.springframework.web.bind.annotation.*

class HelloController : HelloAPI {

    override fun helloWorld():String = "Hello! World!"

    override fun sayHello(@RequestBody name:String): String = "Hello, $name"
}
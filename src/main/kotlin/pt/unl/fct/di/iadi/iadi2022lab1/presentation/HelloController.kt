package pt.unl.fct.di.iadi.iadi2022lab1.presentation

class HelloController : HelloAPI {

    override fun helloWorld():String = "Hello! World!"

    override fun sayHello(greeting: greetingRequest): greetingResponse = greetingResponse("Hello, $greeting.name")
}
package pt.unl.fct.di.iadi.iadi2022lab1.domain

import org.springframework.stereotype.Service

@Service
class UserDomainService {
    val users:MutableList<String> = mutableListOf("Joana")

    fun findUserByName(name:String) = users.find { it == name }

    fun addUser(name:String) = users.add(name)
}
package pt.unl.fct.di.iadi.iadi2022lab1.service

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.iadi2022lab1.data.UserRepository
import pt.unl.fct.di.iadi.iadi2022lab1.domain.UserDomainService

@Service
class UserService(val usersDomain:UserDomainService, val users:UserRepository) {

    fun userExists(name:String):Boolean = users.findByName(name).isPresent

    fun addUser(name:String) { usersDomain.addUser(name) }
}
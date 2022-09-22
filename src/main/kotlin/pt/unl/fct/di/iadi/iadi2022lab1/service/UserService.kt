package pt.unl.fct.di.iadi.iadi2022lab1.service

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.iadi2022lab1.domain.UserDomainService

@Service
class UserService(val users:UserDomainService) {

    fun userExists(name:String) = users.findUserByName(name) != null

    fun addUser(name:String) { users.addUser(name) }
}
package pt.unl.fct.di.iadi.iadi2022lab1.domain

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadi.iadi2022lab1.data.UserDAO
import pt.unl.fct.di.iadi.iadi2022lab1.data.UserRepository
import java.security.InvalidParameterException

@Service
class UserDomainService(val users:UserRepository) {

    fun addUser(name:String) {
        if (name.length < 3)
            throw InvalidParameterException("Name must be longer than 3 characters.")
        users.save(UserDAO(0,name))
    }
}
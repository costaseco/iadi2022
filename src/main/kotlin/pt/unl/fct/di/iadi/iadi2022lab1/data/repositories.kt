package pt.unl.fct.di.iadi.iadi2022lab1.data

import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<UserDAO, Long> {
    fun findByName(name:String):Optional<UserDAO>
}
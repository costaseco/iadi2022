package pt.unl.fct.di.iadi.iadi2022lab1.data

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>
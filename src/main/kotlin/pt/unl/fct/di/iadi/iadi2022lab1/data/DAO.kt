package pt.unl.fct.di.iadi.iadi2022lab1.data

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class UserDAO(@Id val number:Long, val name:String)
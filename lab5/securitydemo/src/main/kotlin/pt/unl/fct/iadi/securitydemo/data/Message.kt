/**
Copyright 2022 João Costa Seco

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package pt.unl.fct.iadi.securitydemo.data

import org.springframework.boot.CommandLineRunner
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import pt.unl.fct.iadi.securitydemo.presentation.MessageDTO
import javax.persistence.*

@Entity
@Table(name="Message_table")
data class Message(
    @Id @GeneratedValue      val id:Long,
    @Column(name="fromUser") val from:String,
    @Column(name="toUser")   val to:String,
                             val content:String
)

interface MessageRepository: CrudRepository<Message, Long>

@Component
class Initializer(
    val messages:MessageRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val initialMessages = mutableListOf(
            Message(1, "a@a.com", "b@b.com", "Message 1"),
            Message(2, "b@b.com", "c@c.com", "Message 2"),
            Message(3, "c@c.com", "a@a.com", "Message 3"),
        )

        messages.saveAll(initialMessages)
    }

}
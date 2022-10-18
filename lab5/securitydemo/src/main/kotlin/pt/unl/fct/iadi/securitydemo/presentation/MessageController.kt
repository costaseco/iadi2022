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

package pt.unl.fct.iadi.securitydemo.presentation

import org.springframework.web.bind.annotation.RestController
import pt.unl.fct.iadi.securitydemo.application.MessageApplication

@RestController
class HelloController : HelloAPI {
    override fun hello(): String = "Hello, World!"
}

@RestController
class MessageController(val app: MessageApplication) : MessageAPI {

    override fun getAll(): Collection<MessageDTO> = app.getAll().map { MessageDTO(it) }

    override fun addOne(message: MessageCreateDTO) {
        app.addOne(message.from, message.to, message.content)
    }

    override fun getOne(id: Long): MessageDTO = MessageDTO(app.getOne(id).get())

    override fun delete(id: Long) = app.delete(id)
}

@RestController
class AdminController(val app: MessageApplication) : AdminAPI {
    override fun dashboard() = app.count()

    override fun reset() {
        app.clear()
    }

}
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

package pt.unl.fct.iadi.securitydemo.application

import org.springframework.stereotype.Service
import pt.unl.fct.iadi.securitydemo.presentation.MessageDTO

@Service
class MessageApplication {

    companion object {
        val messages = mutableListOf(
            MessageDTO(1, "a@a.com", "b@b.com", "Message 1"),
            MessageDTO(2, "b@b.com", "c@c.com", "Message 2"),
            MessageDTO(3, "c@c.com", "a@a.com", "Message 3"),
        )
    }

    fun getAll() = messages

    fun addOne(message: MessageDTO) {
        messages.add(message)
    }

    fun getOne(id: Int) = messages[id]

    fun count() = messages.size

    fun clear() {
        messages.removeAll { true }  // a block { E } is like a lambda (it -> E)
    }

    fun delete(id: Long) {
        messages.removeAll { it.id == id }
    }
}
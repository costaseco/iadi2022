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
import pt.unl.fct.iadi.securitydemo.data.Message
import pt.unl.fct.iadi.securitydemo.data.MessageRepository
import pt.unl.fct.iadi.securitydemo.presentation.MessageDTO

@Service
class MessageApplication(
    val messages:MessageRepository
    ) {

    fun getAll() = messages.findAll()

    fun addOne(from:String, to:String, content:String) {
        messages.save(Message(0, from, to, content))
    }

    fun getOne(id: Long) = messages.findById(id)

    fun count() = messages.count()

    fun clear() {
        messages.deleteAll()
    }

    fun delete(id: Long) {
        messages.deleteById(id)
    }
}
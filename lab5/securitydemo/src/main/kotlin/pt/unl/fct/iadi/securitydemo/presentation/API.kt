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

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import pt.unl.fct.iadi.securitydemo.configuration.securityRules.CanDeleteMyMessages
import pt.unl.fct.iadi.securitydemo.data.Message

data class MessageCreateDTO(val from:String, val to:String, val content:String)
data class MessageDTO(val id:Long, val from:String, val to:String, val content:String) {
    constructor(message: Message) : this(message.id, message.from, message.to, message.content)
}

@RequestMapping("")
interface HelloAPI {

    @GetMapping("hello")
    fun hello():String
}

@RequestMapping("/api/messages")
interface MessageAPI {

    @GetMapping("")
    fun getAll():Collection<MessageDTO>

    @PostMapping("")
    fun addOne(@RequestBody message:MessageCreateDTO):Unit

    @GetMapping("{id}")
    fun getOne(@PathVariable id:Long):MessageDTO

    @DeleteMapping("{id}")
    @CanDeleteMyMessages
    fun delete(@PathVariable id:Long): Unit
}

@RequestMapping("/api/admin")
interface AdminAPI {

    @GetMapping("dashboard")
    fun dashboard():Long

    @PostMapping("messages")
    fun reset():Unit
}
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

package pt.unl.fct.iadi.securitydemo.configuration.securityService

import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import pt.unl.fct.iadi.securitydemo.data.MessageRepository

@Component("mySecurityService")
class SecurityService(
    val messages: MessageRepository
) {

    fun myMessage(principal: User, id:Long): Boolean {
        val msg = messages.findById(id)

        return msg.get().from == principal.username
    }
}
package pt.unl.fct.di.iadi.messages.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class MessageController : MessageAPI {

    override fun getAll(): Collection<MessageListDTO> {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): Optional<MessageDTO> {
        TODO("Not yet implemented")
    }

    override fun addOne(value: MessageCreateDTO) {
        TODO("Not yet implemented")
    }

    override fun updateOne(id: Long, value: MessageCreateDTO) {
        TODO("Not yet implemented")
    }

    override fun deleteOne(id: Long) {
        TODO("Not yet implemented")
    }

}
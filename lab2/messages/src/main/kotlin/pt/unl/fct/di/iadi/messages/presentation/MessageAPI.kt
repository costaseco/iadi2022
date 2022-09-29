package pt.unl.fct.di.iadi.messages.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("messages")
interface MessageAPI: ResourceAPI<Long,MessageDTO,MessageListDTO,MessageCreateDTO> {

    @Operation(summary = "Get all messages")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found all resources", content = [
            (Content(mediaType = "application/json", array = (ArraySchema(schema = Schema(implementation = MessageListDTO::class)))))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any Foos", content = [Content()])]
    )
    override fun getAll(): Collection<MessageListDTO>

    @Operation(summary = "Get one message given an Id")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found the message", content = [
            (Content(mediaType = "application/json", schema = Schema(implementation = MessageDTO::class)))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find the sought message", content = [Content()])]
    )
    override fun getOne(id: Long): Optional<MessageDTO>

    @Operation(summary = "Get one message given an Id")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found the message", content = [
            (Content(mediaType = "application/json", schema = Schema(implementation = MessageDTO::class)))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find the sought message", content = [Content()])]
    )
    override fun addOne(value: MessageCreateDTO)

    override fun updateOne(id: Long)

    override fun deleteOne(id: Long)
}


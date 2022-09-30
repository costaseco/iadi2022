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
interface MessageAPI {

    @Operation(summary = "Get all messages")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found all messages", content = [
            (Content(mediaType = "application/json", array = (ArraySchema(schema = Schema(implementation = MessageListDTO::class)))))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()])]
    )
    @GetMapping("")
    fun getAll(): Collection<MessageListDTO>

    @Operation(summary = "Get one message given an Id")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found the message", content = [
            (Content(mediaType = "application/json", schema = Schema(implementation = MessageDTO::class)))]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find the sought message", content = [Content()])]
    )
    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long): Optional<MessageDTO>

    @Operation(summary = "Add one message")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Added the message", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()])]
    )
    @PostMapping("")
    fun addOne(@RequestBody value: MessageCreateDTO):Unit

    @Operation(summary = "Update one message")
    @ApiResponses(value = [
        ApiResponse(responseCode = "202", description = "Updated the message", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any message", content = [Content()])]
    )
    @PutMapping("{id}")
    fun updateOne(@PathVariable id: Long, @RequestBody value:MessageCreateDTO):Unit

    @Operation(summary = "Delete one message")
    @ApiResponses(value = [
        ApiResponse(responseCode = "202", description = "Deleted the message", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any message", content = [Content()])]
    )
    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable id: Long):Unit
}


package pt.unl.fct.di.iadi.messages.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

interface ResourceAPI<I,T,L,C> {

    @Operation(summary = "Get all resources")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found all resources", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any resources", content = [Content()])]
    )
    @GetMapping("")
    fun getAll():Collection<L>

    @Operation(summary = "Get one resources")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Found the resource", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any resources", content = [Content()])]
    )
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getOne(id:I): Optional<T>

    @Operation(summary = "add one resource")
    @ApiResponses(value = [
        ApiResponse(responseCode = "201", description = "Added the resource", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()])]
    )
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun addOne(@RequestBody value:C):Unit

    @Operation(summary = "update one resource")
    @ApiResponses(value = [
        ApiResponse(responseCode = "202", description = "Added the resource", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any resources", content = [Content()])]
    )
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateOne(id:I):Unit

    @Operation(summary = "delete one resource")
    @ApiResponses(value = [
        ApiResponse(responseCode = "202", description = "Added the resource", content = [Content()]),
        ApiResponse(responseCode = "400", description = "Bad request", content = [Content()]),
        ApiResponse(responseCode = "404", description = "Did not find any resources", content = [Content()])]
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun deleteOne(id:I):Unit

}
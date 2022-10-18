package pt.unl.fct.di.iadi.iadi2022lab1


import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import pt.unl.fct.di.iadi.iadi2022lab1.presentation.GreetingRequest
import pt.unl.fct.di.iadi.iadi2022lab1.presentation.GreetingResponse
import pt.unl.fct.di.iadi.iadi2022lab1.service.UserService

/*
REFS:
https://www.baeldung.com/kotlin/mockmvc-kotlin-dsl

 */


@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class Iadi2022Lab1ApplicationTests {

    @Autowired
    lateinit var mvc:MockMvc

    @Autowired
    lateinit var mapper: ObjectMapper

    @MockBean
    lateinit var userService: UserService

    companion object {
        const val helloURL = "/api/helloworld"

        const val greetingURL = "/api/hello"


    }

    @Test
    fun `test HelloWorld`() {
        mvc
        .get(helloURL) {
            accept = MediaType.APPLICATION_JSON
        }
        .andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { json(mapper.writeValueAsString(GreetingResponse("Hello, World!"))) }
        }
    }

    @Test
    fun `saying hello to Maria`() {
        mvc
        .post(greetingURL) {
            accept = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(GreetingRequest("Maria"))
            contentType = MediaType.APPLICATION_JSON
        }
        .andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON)}
            content { json(mapper.writeValueAsString(GreetingResponse("Hello, stranger!"))) }
        }
    }

    @Test
    fun `with mock service`() {
        Mockito
            .`when`(userService.userExists(anyString()))
            .thenAnswer { it.arguments[0] == "Maria" }

        mvc.post(greetingURL) {
            accept = MediaType.APPLICATION_JSON
            content = mapper.writeValueAsString(GreetingRequest("Maria"))
            contentType = MediaType.APPLICATION_JSON
        }
        .andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON)}
            content { json(mapper.writeValueAsString(GreetingResponse("Hello, Maria!"))) }
        }
    }
}

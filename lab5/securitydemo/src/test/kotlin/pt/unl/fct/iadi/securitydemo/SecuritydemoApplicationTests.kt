package pt.unl.fct.iadi.securitydemo

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.ArgumentMatchers.isA
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

import org.hamcrest.Matchers.*
import org.springframework.test.web.servlet.delete

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class SecuritydemoApplicationTests {

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun `say hello`() {
        mvc.get("/hello") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { "Hello, World!" }
        }
    }

    @Test
    fun `see Messages (not authenticated)`() {
        mvc.get("/api/messages") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isUnauthorized() }
        }
    }

    @Test
    @WithMockUser(username="user",roles= arrayOf("USER"))
    fun `see Messages`() {
        mvc.get("/api/messages") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON) }
            content { jsonPath("$", hasSize<Array<String>>(3)) } // Should not be string
        }
    }

    @Test
    @WithMockUser(username="a@a.com",roles= arrayOf("USER"))
    fun `delete my Message`() {
        mvc.delete("/api/messages/1") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }
    }

    @Test
    @WithMockUser(username="b@b.com",roles= arrayOf("USER"))
    fun `delete not my Message`() {
        mvc.delete("/api/messages/1") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isForbidden() }
        }
    }

    @Test
    fun `see Dashboard (not authenticated)`() {
        mvc.get("/api/admin/dashboard") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isUnauthorized() }
        }
    }

    @Test
    @WithMockUser(username="user",roles= arrayOf("USER"))
    fun `see Dashboard (not authorized)`() {
        mvc.get("/api/admin/dashboard") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isForbidden() }
        }
    }

    @Test
    @WithMockUser(username="admin",roles= arrayOf("ADMIN")) // Could be any user
    fun `see Dashboard`() {
        mvc.get("/api/admin/dashboard") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk() }
        }
    }

}

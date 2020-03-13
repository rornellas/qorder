package br.com.qagile.qorder.core.health

import br.com.qagile.qorder.core.health.core.health.PingHandlerController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@WebMvcTest(PingHandlerController::class)
class PintHandlerControllerTest {

	@Autowired
	lateinit var mvc: MockMvc

	@Autowired
	lateinit var pingHandlerController: PingHandlerController

	@Test
	@Throws(Exception::class)
	fun test_ping_success() {
		this.mvc.perform(MockMvcRequestBuilders.get("/ping"))
				.andExpect(MockMvcResultMatchers.status().isOk)
	}

	@Test
	@Throws(Exception::class)
	fun test_ping_not_found() {

		this.mvc.perform(MockMvcRequestBuilders.get("/ping1"))
				.andExpect(MockMvcResultMatchers.status().isNotFound)
	}

	@Test
	@Throws(Exception::class)
	fun test_ping_checj_response() {
		Assertions.assertEquals("pong => qorder", pingHandlerController.health())
	}
}

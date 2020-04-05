package br.com.qagile.qorder.api.controller

import br.com.qagile.qorder.api.router.OrderRouter
import br.com.qagile.qorder.QorderApplication
import br.com.qagile.qorder.api.model.request.MenuItemRequest
import br.com.qagile.qorder.api.model.request.PlaceOrderRequest
import br.com.qagile.qorder.api.service.impl.OrderService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@ExtendWith(SpringExtension::class)
@WebMvcTest(OrderController::class)
class OrderControllerTest {

	@Autowired
	lateinit var mvc: MockMvc

	@Autowired
	lateinit var objectMapper: ObjectMapper

	@MockBean
	lateinit var orderService: OrderService

	private val userToken = "rodrigo.ornellas"
	private val safetyHash = "1220c26144f86a3f4de116656a04f472"
	private val productList = hashSetOf(
		MenuItemRequest("95f2c97ab25806959b1a449fd33dd2bf", 2),
		MenuItemRequest("95f2c97ab25806959b1a449fd33dd2bz", 1),
		MenuItemRequest("95f2c97ab25806959b1a449fd33dd2bc", 5)
	)

	@Test
	@Throws(Exception::class)
	fun test_order_creation_success() {
		val por = PlaceOrderRequest(userToken, safetyHash, productList)

		this.mvc.perform(
					MockMvcRequestBuilders.post(OrderRouter.PLACE_ORDER)
					.content(objectMapper.writeValueAsString(por))
					.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().isCreated)
	}

}

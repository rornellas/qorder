package br.com.qagile.qorder.api.controller

import br.com.qagile.qorder.api.router.OrderRouter
import br.com.qagile.qorder.api.model.request.PlaceOrderRequest
import br.com.qagile.qorder.api.model.response.PlacedOrderResponse
import br.com.qagile.qorder.api.service.IOrderService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import javax.validation.constraints.NotEmpty

@RestController
class OrderController(val orderService: IOrderService) {

    @PostMapping(OrderRouter.PLACE_ORDER)
    @ResponseStatus(HttpStatus.CREATED)
    fun placeOrder(@NotEmpty @RequestBody createOrder: PlaceOrderRequest,
                   @RequestHeader("safety_hash") safetyHash: String,
                   @RequestHeader("user_token") userToken: String
    ) : Mono<PlacedOrderResponse> {
        return orderService.placeOrder(createOrder, userToken, safetyHash)
    }

}

package br.com.qagile.qorder.api.controller

import br.com.qagile.qorder.api.controller.request.PlaceOrderRequest
import br.com.qagile.qorder.api.controller.response.PlacedOrderResponse
import br.com.qagile.qorder.api.router.OrderRouter
import br.com.qagile.qorder.api.service.IOrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class OrderController(val orderService: IOrderService) {

    @PostMapping(OrderRouter.PLACE_ORDER)
    fun placeOrder(createOrder: PlaceOrderRequest) : Mono<PlacedOrderResponse> {
        return orderService.placeOrder(createOrder)
    }

}

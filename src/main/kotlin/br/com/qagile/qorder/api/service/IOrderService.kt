package br.com.qagile.qorder.core.health.api.service

import br.com.qagile.qorder.core.health.api.model.request.PlaceOrderRequest
import br.com.qagile.qorder.core.health.api.model.response.PlacedOrderResponse
import reactor.core.publisher.Mono

interface IOrderService {

    fun placeOrder(createOrder: PlaceOrderRequest): Mono<PlacedOrderResponse>

}

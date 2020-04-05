package br.com.qagile.qorder.api.service

import br.com.qagile.qorder.api.model.request.PlaceOrderRequest
import br.com.qagile.qorder.api.model.response.PlacedOrderResponse
import reactor.core.publisher.Mono

interface IOrderService {

    fun placeOrder(createOrder: PlaceOrderRequest): Mono<PlacedOrderResponse>

}

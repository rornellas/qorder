package br.com.qagile.qorder.api.service

import br.com.qagile.qorder.api.controller.request.PlaceOrderRequest
import br.com.qagile.qorder.api.document.Order
import reactor.core.publisher.Mono

interface IOrderService {

    fun placeOrder(createOrder: PlaceOrderRequest): Mono<Order>

}

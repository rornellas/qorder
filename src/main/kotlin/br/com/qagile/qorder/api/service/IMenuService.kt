package br.com.qagile.qorder.api.service

import br.com.qagile.qorder.api.document.Order
import br.com.qagile.qorder.api.service.response.OrderValidationResponse
import reactor.core.publisher.Mono
import retrofit2.http.Body
import retrofit2.http.POST

interface IMenuService {
    @POST("/validate")
    fun validateOrder(@Body order: Order) : Mono<OrderValidationResponse>
}

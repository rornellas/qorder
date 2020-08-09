package br.com.qagile.qorder.api.service

import br.com.qagile.qorder.api.document.Order
import br.com.qagile.qorder.api.model.response.PlacedOrderResponse
import reactor.core.publisher.Mono
import retrofit2.http.Body
import retrofit2.http.POST

interface ITransacionService {
    @POST("/")
    fun createTransaction(@Body order: Order) : Mono<PlacedOrderResponse>
}

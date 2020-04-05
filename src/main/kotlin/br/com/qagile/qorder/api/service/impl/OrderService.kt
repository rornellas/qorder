package br.com.qagile.qorder.api.service.impl

import br.com.qagile.qorder.api.document.Order
import br.com.qagile.qorder.api.model.request.PlaceOrderRequest
import br.com.qagile.qorder.api.model.response.PlacedOrderResponse
import br.com.qagile.qorder.api.repository.IOrderRepository
import br.com.qagile.qorder.api.service.IOrderService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.fromCallable
import reactor.core.scheduler.Schedulers

@Service
class OrderService(val orderRepository: IOrderRepository): IOrderService {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    private fun createOrder(order: Order): Order {
        return orderRepository.save(order)
    }

    override fun placeOrder(createOrder: PlaceOrderRequest, userToken: String, safetyHash: String): Mono<PlacedOrderResponse> {
        return fromCallable{ createOrder(createOrder.convertToOrder(userToken = userToken, safetyHash = safetyHash)) }
                .publishOn(Schedulers.elastic())
                .flatMap{ data: Order -> Mono.justOrEmpty(PlacedOrderResponse(data)) }
                .doOnError{ e: Throwable? -> log.error(e?.message, e) }
    }

}

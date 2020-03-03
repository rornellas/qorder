package br.com.qagile.qorder.api.service.impl

import br.com.qagile.qorder.api.controller.request.PlaceOrderRequest
import br.com.qagile.qorder.api.document.Order
import br.com.qagile.qorder.api.service.IOrderService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.fromCallable
import reactor.core.scheduler.Schedulers
import java.util.concurrent.Callable
import java.util.function.Consumer
import java.util.function.Function


@Service
class OrderService: IOrderService {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    private fun createOrder(order: Order): Order {
        return Order()
    }

    override fun placeOrder(createOrder: PlaceOrderRequest): Mono<Order> {
        return fromCallable{ createOrder(createOrder.convertToOrder()) }
                .publishOn(Schedulers.elastic())
                .flatMap{ data: Order? -> Mono.justOrEmpty(data) }
                .doOnError{ e: Throwable? -> log.error(e?.message, e) }
    }

}

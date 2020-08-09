package br.com.qagile.qorder.api.service.impl

import br.com.qagile.qorder.api.document.Order
import br.com.qagile.qorder.api.model.request.PlaceOrderRequest
import br.com.qagile.qorder.api.model.response.PlacedOrderResponse
import br.com.qagile.qorder.api.repository.IOrderRepository
import br.com.qagile.qorder.api.service.IMenuService
import br.com.qagile.qorder.api.service.IOrderService
import br.com.qagile.qorder.api.service.ITransacionService
import br.com.qagile.qorder.api.service.request.OrderValidationRequest
import br.com.qagile.qorder.api.service.response.OrderValidationResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.fromCallable
import reactor.core.scheduler.Schedulers

@Service
class OrderService(val orderRepository: IOrderRepository): IOrderService {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var transactionService: ITransacionService

    @Autowired
    lateinit var menuService: IMenuService

    private fun createOrder(order: Order) = orderRepository.save(order)

    override fun placeOrder(createOrder: PlaceOrderRequest, userToken: String, safetyHash: String): Mono<PlacedOrderResponse> {
        val convertToOrder = createOrder.convertToOrder(userToken = userToken, safetyHash = safetyHash)

        return menuService.validateOrder(convertToOrder)
                .filter { it.isValid }
                .flatMap { createOrder(convertToOrder) }
                .flatMap { transactionService.createTransaction(it) }
                .doOnError { e: Throwable? -> log.error(e?.message, e) }
    }

}

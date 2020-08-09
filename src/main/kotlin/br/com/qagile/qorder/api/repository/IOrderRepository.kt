package br.com.qagile.qorder.api.repository

import br.com.qagile.qorder.api.document.Order
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface IOrderRepository: ReactiveCrudRepository<Order, String> {

}
package br.com.qagile.qorder.core.health.api.repository

import br.com.qagile.qorder.core.health.api.document.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface IOrderRepository: MongoRepository<Order, String> {

}
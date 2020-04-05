package br.com.qagile.qorder.api.repository

import br.com.qagile.qorder.api.document.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface IOrderRepository: MongoRepository<Order, String> {

}
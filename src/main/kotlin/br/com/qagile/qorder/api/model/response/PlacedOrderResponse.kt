package br.com.qagile.qorder.api.model.response

import br.com.qagile.qorder.api.document.Order

data class PlacedOrderResponse(
    var userToken: String? = null,
    var safetyHash: String? = null
) {
    constructor(order: Order) : this() {
        this.userToken = order.userToken
        this.safetyHash = order.safetyHash
    }
}

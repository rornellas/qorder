package br.com.qagile.qorder.api.controller.request

import br.com.qagile.qorder.api.document.Order

data class PlaceOrderRequest(
    var userToken: String? = null,
    var safetyHash: String? = null,
    var menuItems: List<MenuItemRequest>? = null
) {
    fun convertToOrder(): Order {
        return Order(userToken, safetyHash, menuItems)
    }
}

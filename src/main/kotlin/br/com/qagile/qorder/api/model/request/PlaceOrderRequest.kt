package br.com.qagile.qorder.api.model.request

import br.com.qagile.qorder.api.document.Order
import br.com.qagile.qorder.api.model.request.MenuItemRequest
import com.fasterxml.jackson.annotation.JsonProperty

data class PlaceOrderRequest(
    @JsonProperty("menu_items")
    var menuItems: Collection<MenuItemRequest>? = null
) {
    fun convertToOrder(userToken: String, safetyHash: String): Order {
        return Order(userToken, safetyHash, menuItems)
    }
}

package br.com.qagile.qorder.core.health.api.model.request

import br.com.qagile.qorder.core.health.api.document.Order
import com.fasterxml.jackson.annotation.JsonProperty

data class PlaceOrderRequest(
    @JsonProperty("user_token")
    var userToken: String? = null,
    @JsonProperty("safety_hash")
    var safetyHash: String? = null,
    @JsonProperty("menu_items")
    var menuItems: Collection<MenuItemRequest>? = null
) {
    fun convertToOrder(): Order {
        return Order(userToken, safetyHash, menuItems)
    }
}

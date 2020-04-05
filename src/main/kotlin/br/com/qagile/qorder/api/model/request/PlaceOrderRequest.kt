package br.com.qagile.qorder.api.model.request

import br.com.qagile.qorder.api.document.Order
import br.com.qagile.qorder.api.model.request.MenuItemRequest
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

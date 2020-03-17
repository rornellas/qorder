package br.com.qagile.qorder.core.health.api.document

import br.com.qagile.qorder.core.health.api.model.request.MenuItemRequest

class Order(
    var userToken: String? = null,
    var safetyHash: String? = null,
    var menuItems: Collection<MenuItemRequest>? = null
)

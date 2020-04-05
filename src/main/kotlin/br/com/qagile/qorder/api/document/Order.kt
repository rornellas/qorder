package br.com.qagile.qorder.api.document

import br.com.qagile.qorder.api.model.request.MenuItemRequest

class Order(
    var userToken: String? = null,
    var safetyHash: String? = null,
    var menuItems: Collection<MenuItemRequest>? = null
)

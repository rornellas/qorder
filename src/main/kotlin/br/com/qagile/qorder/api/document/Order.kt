package br.com.qagile.qorder.api.document

import br.com.qagile.qorder.api.controller.request.MenuItemRequest

class Order(
    var userToken: String? = null,
    var safetyHash: String? = null,
    var menuItems: List<MenuItemRequest>? = null
)

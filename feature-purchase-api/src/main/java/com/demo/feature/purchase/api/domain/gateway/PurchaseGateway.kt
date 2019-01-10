package com.demo.feature.purchase.api.domain.gateway

/**
 * @author Sergey Chuprin
 */
interface PurchaseGateway {

    fun purchase(productId: String): Boolean

}
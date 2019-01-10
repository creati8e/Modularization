package com.demo.feature.purchase.api.di

import com.demo.feature.purchase.api.domain.gateway.PurchaseGateway

/**
 * @author Sergey Chuprin
 */
interface PurchaseApi {

    val purchaseGateway: PurchaseGateway

}
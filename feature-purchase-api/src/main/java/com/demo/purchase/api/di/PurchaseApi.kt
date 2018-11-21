package com.demo.purchase.api.di

import com.demo.purchase.api.domain.interactor.PurchaseGateway

/**
 * @author Sergey Chuprin
 */
interface PurchaseApi {

    val purchaseGateway: PurchaseGateway

}
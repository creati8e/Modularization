package demo.com.purchase.api.di

import demo.com.purchase.api.domain.interactor.PurchaseGateway

/**
 * @author Sergey Chuprin
 */
interface PurchaseApi {

    val purchaseGateway: PurchaseGateway

}
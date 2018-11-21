package com.demo.purchase.impl.domain

import com.demo.purchase.api.domain.interactor.PurchaseGateway
import com.demo.purchase.impl.data.PurchaseNetworkDataSource

/**
 * @author Sergey Chuprin
 */
class PurchaseGatewayImpl(
    private val networkDataSource: PurchaseNetworkDataSource
) : PurchaseGateway {

    override fun purchase(productId: String): Boolean {
        return networkDataSource.verify(productId)
    }

}
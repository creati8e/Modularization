package com.demo.feature.purchase.impl.data.gateway

import com.demo.feature.purchase.api.domain.gateway.PurchaseGateway
import com.demo.feature.purchase.impl.data.datasource.PurchaseNetworkDataSource

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
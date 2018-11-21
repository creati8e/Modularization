package demo.com.purchase.impl.domain

import demo.com.purchase.api.domain.interactor.PurchaseGateway
import demo.com.purchase.impl.data.PurchaseNetworkDataSource

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
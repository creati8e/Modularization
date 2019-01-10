package com.demo.feature.purchase.impl.data.datasource

/**
 * @author Sergey Chuprin
 */
interface PurchaseNetworkDataSource {

    fun verify(productId: String): Boolean

}
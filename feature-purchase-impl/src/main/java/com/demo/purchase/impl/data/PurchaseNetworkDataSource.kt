package com.demo.purchase.impl.data

/**
 * @author Sergey Chuprin
 */
interface PurchaseNetworkDataSource {

    fun verify(productId: String): Boolean

}
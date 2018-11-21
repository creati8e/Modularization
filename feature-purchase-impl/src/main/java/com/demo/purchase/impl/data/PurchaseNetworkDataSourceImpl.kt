package com.demo.purchase.impl.data

import android.content.Context

/**
 * @author Sergey Chuprin
 */
@Suppress("unused", "UNUSED_PARAMETER")
class PurchaseNetworkDataSourceImpl(
    private val context: Context
) : PurchaseNetworkDataSource {

    override fun verify(productId: String): Boolean {
        return true
    }

}
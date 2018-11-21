package demo.com.purchase.impl.data

/**
 * @author Sergey Chuprin
 */
interface PurchaseNetworkDataSource {

    fun verify(productId: String): Boolean

}
package demo.com.purchase.api.domain.interactor

/**
 * @author Sergey Chuprin
 */
interface PurchaseGateway {

    fun purchase(productId: String): Boolean

}
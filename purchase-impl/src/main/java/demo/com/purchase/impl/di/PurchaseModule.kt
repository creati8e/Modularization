package demo.com.purchase.impl.di

import android.content.Context
import dagger.Module
import dagger.Provides
import demo.com.core.api.di.scope.PerFeature
import demo.com.purchase.api.domain.interactor.PurchaseGateway
import demo.com.purchase.impl.data.PurchaseNetworkDataSource
import demo.com.purchase.impl.data.PurchaseNetworkDataSourceImpl
import demo.com.purchase.impl.domain.PurchaseGatewayImpl

/**
 * @author Sergey Chuprin
 */
@Module
class PurchaseModule {

    @Provides
    @PerFeature
    fun providePurchaseNetworkDataSource(context: Context): PurchaseNetworkDataSource {
        return PurchaseNetworkDataSourceImpl(context)
    }

    @Provides
    @PerFeature
    fun providePurchaseGateway(
        networkDataSource: PurchaseNetworkDataSource
    ): PurchaseGateway {
        return PurchaseGatewayImpl(networkDataSource)
    }

}
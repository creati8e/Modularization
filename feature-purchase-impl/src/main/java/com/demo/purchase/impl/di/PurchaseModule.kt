package com.demo.purchase.impl.di

import android.content.Context
import com.demo.core.api.di.scope.PerFeature
import com.demo.purchase.api.domain.interactor.PurchaseGateway
import com.demo.purchase.impl.data.PurchaseNetworkDataSource
import com.demo.purchase.impl.data.PurchaseNetworkDataSourceImpl
import com.demo.purchase.impl.domain.PurchaseGatewayImpl
import dagger.Module
import dagger.Provides

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
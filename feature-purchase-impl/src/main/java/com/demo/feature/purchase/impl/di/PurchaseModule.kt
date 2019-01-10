package com.demo.feature.purchase.impl.di

import android.content.Context
import com.demo.core.api.di.scope.PerFeature
import com.demo.feature.purchase.api.domain.gateway.PurchaseGateway
import com.demo.feature.purchase.impl.data.datasource.PurchaseNetworkDataSource
import com.demo.feature.purchase.impl.data.datasource.PurchaseNetworkDataSourceImpl
import com.demo.feature.purchase.impl.data.gateway.PurchaseGatewayImpl
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
package com.demo.modularization

import android.app.Application
import android.content.Context
import com.demo.modularization.di.AppComponent
import com.demo.modularization.di.DaggerAppComponent
import com.demo.modularization.di.DaggerNavigationComponent
import demo.com.core.api.AppHolder
import demo.com.core.api.di.provider.ApplicationProvider
import demo.com.core.impl.di.DaggerAppUtilsComponent
import demo.com.core.impl.di.DaggerCoreComponent
import demo.com.navigation.NavigationHolder
import demo.com.navigation.NavigationProvider
import demo.com.purchase.api.di.PurchaseApi
import demo.com.purchase.api.di.PurchaseApiProvider
import demo.com.purchase.impl.di.DaggerPurchaseComponent

/**
 * @author Sergey Chuprin
 */
class ModularizationApplication :
    Application(),
    AppHolder,
    NavigationHolder,
    PurchaseApiProvider {

    private companion object {
        @Suppress("ObjectPropertyName")
        lateinit var _component: AppComponent
    }

    val component: AppComponent get() = _component

    override val appContext: Context get() = this

    override val purchaseApi: PurchaseApi get() = _component

    override val appProvider: ApplicationProvider get() = _component

    override val navigationProvider: NavigationProvider get() = _component

    override fun onCreate() {
        super.onCreate()

        val core = DaggerCoreComponent.builder().build()
        val navigation = DaggerNavigationComponent.builder().build()
        val appUtils = DaggerAppUtilsComponent.builder().app(this).build()
        val purchaseApi = DaggerPurchaseComponent.builder().appUtilsProvider(appUtils).build()

        _component = DaggerAppComponent
            .builder()
            .purchaseApi(purchaseApi)
            .dataSourcesProvider(core)
            .appUtilsProvider(appUtils)
            .navigationProvider(navigation)
            .build()
    }

}
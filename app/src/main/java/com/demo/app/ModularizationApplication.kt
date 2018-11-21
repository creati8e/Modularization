package com.demo.app

import android.app.Application
import android.content.Context
import com.demo.app.di.AppComponent
import com.demo.app.di.DaggerAppComponent
import com.demo.app.di.DaggerNavigationComponent
import com.demo.core.api.AppHolder
import com.demo.core.api.di.provider.ApplicationProvider
import com.demo.core.impl.di.DaggerAppUtilsComponent
import com.demo.core.impl.di.DaggerCoreComponent
import com.demo.core.navigation.NavigationHolder
import com.demo.core.navigation.NavigationProvider
import com.demo.purchase.api.di.PurchaseApi
import com.demo.purchase.api.di.PurchaseApiProvider
import com.demo.purchase.impl.di.DaggerPurchaseComponent

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
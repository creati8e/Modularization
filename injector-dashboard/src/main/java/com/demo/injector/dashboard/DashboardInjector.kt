package com.demo.injector.dashboard

import com.demo.core.impl.di.CoreComponent
import com.demo.feature.purchase.impl.di.DaggerPurchaseComponent

/**
 * @author Sergey Chuprin
 */
object DashboardInjector {

    fun getDashboardDependencies(): DashboardDependencies {
        return DaggerDashboardDependenciesComponent
            .builder()
            .appTools(CoreComponent.get())
            .navigationTools(CoreComponent.get())
            .purchaseApi(
                DaggerPurchaseComponent
                    .builder()
                    .appTools(CoreComponent.get())
                    .build()
            )
            .build()
    }

}
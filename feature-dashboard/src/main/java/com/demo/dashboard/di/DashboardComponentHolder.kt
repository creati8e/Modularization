package com.demo.dashboard.di

import android.app.Application
import com.demo.core.api.AppHolder
import com.demo.core.navigation.NavigationHolder
import com.demo.core.ui.FeatureComponent
import com.demo.dashboard.presentation.DashboardFragment
import com.demo.purchase.api.di.PurchaseApiProvider

/**
 * @author Sergey Chuprin
 */
class DashboardComponentHolder(
    private val application: Application
) : FeatureComponent<DashboardFragment> {

    private var component: DashboardComponent? = null

    override fun inject(target: DashboardFragment) = component?.inject(target) ?: Unit

    override fun onCreate() {
        component = DaggerDashboardComponent
            .builder()
            .appUtilsProvider((application as AppHolder).appProvider)
            .purchaseApi((application as PurchaseApiProvider).purchaseApi)
            .navigationProvider((application as NavigationHolder).navigationProvider)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
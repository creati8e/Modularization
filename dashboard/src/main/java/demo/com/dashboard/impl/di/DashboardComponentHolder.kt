package demo.com.dashboard.impl.di

import android.app.Application
import demo.com.core.api.AppHolder
import demo.com.dashboard.impl.presentation.DashboardFragment
import demo.com.navigation.NavigationHolder
import demo.com.purchase.api.di.PurchaseApiProvider
import demo.com.utils.ui.FeatureComponent

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
package demo.com.dashboard.impl.di

import android.app.Application
import demo.com.componentstore.FeatureComponent
import demo.com.core.api.AppHolder
import demo.com.dashboard.impl.presentation.DashboardFragment

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
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
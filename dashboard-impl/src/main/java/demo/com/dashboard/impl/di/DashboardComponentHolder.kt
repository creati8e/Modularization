package demo.com.dashboard.impl.di

import android.app.Application
import demo.com.componentstore.FeatureComponent
import demo.com.core.api.App
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
        val appProvider = (application as App).appProvider
        component = DaggerDashboardComponent
            .builder()
            .appUtilsProvider(appProvider)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
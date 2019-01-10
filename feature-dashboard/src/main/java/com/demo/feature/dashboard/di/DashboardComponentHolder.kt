package com.demo.feature.dashboard.di

import com.demo.core.api.ui.FeatureComponent
import com.demo.feature.dashboard.presentation.DashboardFragment
import com.demo.injector.dashboard.DashboardInjector

/**
 * @author Sergey Chuprin
 */
class DashboardComponentHolder : FeatureComponent<DashboardFragment> {

    private var component: DashboardComponent? = null

    override fun inject(target: DashboardFragment) = component?.inject(target) ?: Unit

    override fun onCreate() {
        component = DaggerDashboardComponent
            .builder()
            .dashboardDependencies(DashboardInjector.getDashboardDependencies())
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
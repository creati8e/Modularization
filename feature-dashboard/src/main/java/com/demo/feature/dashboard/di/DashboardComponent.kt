package com.demo.feature.dashboard.di

import com.demo.core.api.di.scope.PerFeature
import com.demo.feature.dashboard.presentation.DashboardFragment
import com.demo.injector.dashboard.DashboardDependencies
import com.demo.injector.dashboard.DashboardInjector
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(
    modules = [DashboardModule::class],
    dependencies = [DashboardDependencies::class]
)
interface DashboardComponent {

    companion object {
        fun provide(): DashboardComponent {
            return DaggerDashboardComponent
                .builder()
                .dashboardDependencies(DashboardInjector.getDashboardDependencies())
                .build()
        }
    }

    fun inject(fragment: DashboardFragment)

}
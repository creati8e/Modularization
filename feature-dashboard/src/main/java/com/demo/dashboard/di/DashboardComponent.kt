package com.demo.dashboard.di

import com.demo.core.api.di.provider.AppUtilsProvider
import com.demo.core.api.di.scope.PerFeature
import com.demo.core.navigation.NavigationProvider
import com.demo.dashboard.presentation.DashboardFragment
import com.demo.purchase.api.di.PurchaseApi
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(
    modules = [DashboardModule::class],
    dependencies = [
        PurchaseApi::class,
        AppUtilsProvider::class,
        NavigationProvider::class
    ]
)
interface DashboardComponent {

    fun inject(fragment: DashboardFragment)

}
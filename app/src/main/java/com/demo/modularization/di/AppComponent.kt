package com.demo.modularization.di

import com.demo.modularization.MainFragment
import dagger.Component
import demo.com.core.api.di.provider.AppUtilsProvider
import demo.com.core.api.di.provider.ApplicationProvider
import demo.com.core.api.di.provider.DataSourcesProvider
import demo.com.navigation.NavigationProvider
import demo.com.purchase.api.di.PurchaseApi
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(
    dependencies = [
        PurchaseApi::class,
        AppUtilsProvider::class,
        NavigationProvider::class,
        DataSourcesProvider::class
    ]
)
interface AppComponent : ApplicationProvider, NavigationProvider, PurchaseApi {

    fun inject(mainFragment: MainFragment)

}
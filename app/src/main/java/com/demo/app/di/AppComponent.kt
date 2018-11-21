package com.demo.app.di

import com.demo.app.MainFragment
import com.demo.core.api.di.provider.AppUtilsProvider
import com.demo.core.api.di.provider.ApplicationProvider
import com.demo.core.api.di.provider.DataSourcesProvider
import com.demo.core.navigation.NavigationProvider
import com.demo.purchase.api.di.PurchaseApi
import dagger.Component
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
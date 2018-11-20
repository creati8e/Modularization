package com.demo.modularization.di

import com.demo.modularization.MainFragment
import dagger.Component
import demo.com.core.api.di.provider.AppUtilsProvider
import demo.com.core.api.di.provider.ApplicationProvider
import demo.com.core.api.di.provider.DataSourcesProvider
import demo.com.navigation.NavigationProvider
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(
    dependencies = [
        DataSourcesProvider::class,
        AppUtilsProvider::class,
        NavigationProvider::class
    ]
)
interface AppComponent : ApplicationProvider, NavigationProvider {

    fun inject(mainFragment: MainFragment)

}
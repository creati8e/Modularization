package com.demo.modularization

import android.app.Application
import android.content.Context
import com.demo.modularization.di.AppComponent
import com.demo.modularization.di.DaggerAppComponent
import com.demo.modularization.di.DaggerNavigationComponent
import demo.com.core.api.App
import demo.com.core.api.di.provider.ApplicationProvider
import demo.com.core.impl.di.DaggerAppUtilsComponent
import demo.com.core.impl.di.DaggerCoreComponent
import demo.com.navigation.NavigationHolder
import demo.com.navigation.NavigationProvider

/**
 * @author Sergey Chuprin
 */
class ModularizationApplication : Application(), App, NavigationHolder {

    private companion object {
        @Suppress("ObjectPropertyName")
        lateinit var _component: AppComponent
    }

    val component: AppComponent get() = _component

    override val appContext: Context get() = this

    override val appProvider: ApplicationProvider get() = _component

    override val navigationProvider: NavigationProvider get() = _component

    override fun onCreate() {
        super.onCreate()
        _component = DaggerAppComponent
            .builder()
            .dataSourcesProvider(DaggerCoreComponent.builder().build())
            .navigationProvider(DaggerNavigationComponent.builder().build())
            .appUtilsProvider(DaggerAppUtilsComponent.builder().app(this).build())
            .build()
    }

}
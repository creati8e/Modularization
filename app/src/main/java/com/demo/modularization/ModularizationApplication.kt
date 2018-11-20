package com.demo.modularization

import android.app.Application
import android.content.Context
import com.demo.modularization.di.DaggerAppComponent
import demo.com.core.api.App
import demo.com.core.api.ApplicationProvider
import demo.com.core.impl.di.DaggerAppContextComponent
import demo.com.core.impl.di.DaggerCoreComponent

/**
 * @author Sergey Chuprin
 */
class ModularizationApplication : Application(), App {

    override fun applicationContext(): Context {
        return this
    }

    override val applicationProvider: ApplicationProvider by lazy {
        DaggerAppComponent
            .builder()
            .dataSourcesProvider(DaggerCoreComponent.builder().build())
            .appContextProvider(DaggerAppContextComponent.builder().app(this).build())
            .build()
    }

}
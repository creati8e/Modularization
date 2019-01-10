package com.demo.app

import android.app.Application
import com.demo.app.di.AppComponent
import com.demo.app.di.DaggerAppComponent
import com.demo.app.di.NavigationComponent
import com.demo.core.impl.di.CoreComponent

/**
 * @author Sergey Chuprin
 */
class ModularizationApplication : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        CoreComponent.init(this, NavigationComponent.instance)

        component = DaggerAppComponent
            .builder()
            .appTools(CoreComponent.get())
            .navigationTools(CoreComponent.get())
            .build()
    }

}
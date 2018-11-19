package com.demo.modularization

import android.app.Application
import com.demo.modularization.di.AppComponent
import com.demo.modularization.di.DaggerAppComponent

/**
 * @author Sergey Chuprin
 */
class ModularizationApplication : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().application(this).build()
    }

}
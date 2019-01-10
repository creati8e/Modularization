package com.demo.injector

import com.demo.core.impl.di.CoreComponent
import com.demo.injector.auth.AuthDependencies
import com.demo.injector.auth.DaggerAuthDependenciesComponent
import com.demo.injector.settings.DaggerSettingDependenciesComponent
import com.demo.injector.settings.SettingsDependencies

object Injector {

    fun getAuthDependencies(): AuthDependencies {
        return DaggerAuthDependenciesComponent
            .builder()
            .navigationTools(CoreComponent.get())
            .dataSourcesTools(CoreComponent.get())
            .build()
    }

    fun getSettingDependencies(): SettingsDependencies {
        return DaggerSettingDependenciesComponent
            .builder()
            .appTools(CoreComponent.get())
            .build()
    }

}
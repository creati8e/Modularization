package com.demo.app.di

import com.demo.core.api.di.tools.NavigationTools
import dagger.Component
import javax.inject.Singleton

/**
 * @author Sergey Chuprin
 */
@Singleton
@Component(modules = [NavigationModule::class])
interface NavigationComponent : NavigationTools {

    companion object {
        val instance: NavigationComponent by lazy { DaggerNavigationComponent.create() }
    }

}
package com.demo.app.di

import com.demo.app.navigation.NavigateFromAuthToDashboardImpl
import com.demo.app.navigation.NavigateFromDashboardToSettingsImpl
import com.demo.app.navigation.NavigateToAuthImpl
import com.demo.core.navigation.actions.NavigateFromAuthToDashboard
import com.demo.core.navigation.actions.NavigateFromDashboardToSettings
import com.demo.core.navigation.actions.NavigateToAuth
import dagger.Module
import dagger.Provides

/**
 * @author Sergey Chuprin
 */
@Module
class NavigationModule {

    @Provides
    fun provideNavigateFromAuthToDashboard(): NavigateFromAuthToDashboard {
        return NavigateFromAuthToDashboardImpl()
    }

    @Provides
    fun provideNavigateToAuth(): NavigateToAuth = NavigateToAuthImpl()

    @Provides
    fun provideNavigateFromDashboardToSettings(): NavigateFromDashboardToSettings {
        return NavigateFromDashboardToSettingsImpl()
    }

}
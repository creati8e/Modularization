package com.demo.modularization.di

import com.demo.modularization.navigation.NavigateFromAuthToDashboardImpl
import com.demo.modularization.navigation.NavigateToAuthImpl
import dagger.Module
import dagger.Provides
import demo.com.navigation.actions.NavigateFromAuthToDashboard
import demo.com.navigation.actions.NavigateToAuth

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

}
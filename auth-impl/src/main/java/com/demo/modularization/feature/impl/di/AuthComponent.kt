package com.demo.modularization.feature.impl.di

import com.demo.modularization.feature.impl.presentation.AuthFragment
import dagger.Component
import demo.com.core.api.di.provider.DataSourcesProvider
import demo.com.core.api.di.scope.PerFeature
import demo.com.navigation.NavigationProvider

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(
    modules = [AuthModule::class],
    dependencies = [DataSourcesProvider::class, NavigationProvider::class]
)
interface AuthComponent {

    fun inject(fragment: AuthFragment)

}
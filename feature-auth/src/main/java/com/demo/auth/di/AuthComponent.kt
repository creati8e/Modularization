package com.demo.auth.di

import com.demo.auth.presentation.AuthFragment
import com.demo.core.api.di.provider.DataSourcesProvider
import com.demo.core.api.di.scope.PerFeature
import com.demo.core.navigation.NavigationProvider
import dagger.Component

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
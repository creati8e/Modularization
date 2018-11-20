package com.demo.modularization.feature.impl.di

import com.demo.modularization.feature.api.AuthApi
import com.demo.modularization.feature.impl.presentation.AuthFragment
import dagger.Component
import demo.com.core.api.DataSourcesProvider

/**
 * @author Sergey Chuprin
 */
@Component(
    modules = [AuthModule::class],
    dependencies = [DataSourcesProvider::class]
)
interface AuthComponent : AuthApi {

    fun inject(fragment: AuthFragment)

}
package com.demo.feature.auth.di

import com.demo.core.api.di.scope.PerFeature
import com.demo.feature.auth.presentation.AuthFragment
import com.demo.injector.Injector
import com.demo.injector.auth.AuthDependencies
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(
    modules = [AuthModule::class],
    dependencies = [AuthDependencies::class]
)
interface AuthComponent {

    companion object {
        fun provide(): AuthComponent {
            return DaggerAuthComponent
                .builder()
                .authDependencies(Injector.getAuthDependencies())
                .build()
        }
    }

    fun inject(fragment: AuthFragment)

}
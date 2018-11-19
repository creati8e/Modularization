package com.demo.modularization.feature.impl.di

import com.demo.modularization.feature.api.AuthApi
import com.demo.modularization.feature.impl.presentation.AuthFragment
import dagger.Component
import demo.com.core.api.CoreApi

/**
 * @author Sergey Chuprin
 */
@Component(
    modules = [AuthModule::class],
    dependencies = [AuthDependencies::class]
)
interface AuthComponent : AuthApi {

    fun inject(fragment: AuthFragment)

    companion object {

        private var component: AuthComponent? = null

        @Synchronized
        fun initAndGet(authDependencies: AuthDependencies): AuthComponent {
            if (component != null) return component!!
            component = DaggerAuthComponent
                .builder()
                .authDependencies(authDependencies)
                .build()
            return component!!
        }

        fun get(): AuthComponent = requireNotNull(component)

        fun reset() {
            component = null
        }

    }

    @Component(dependencies = [CoreApi::class])
    interface AuthDependenciesComponent : AuthDependencies

}
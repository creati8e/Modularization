package com.demo.modularization.feature.impl.di

import com.demo.modularization.feature.api.di.AuthApi
import com.demo.modularization.feature.impl.AuthFragment
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@Component(modules = [AuthModule::class])
interface AuthComponent : AuthApi {

    fun inject(fragment: AuthFragment)

    companion object {

        private var component: AuthComponent? = null

        @Synchronized
        fun initAndGet(): AuthComponent {
            if (component != null) return component!!
            component = DaggerAuthComponent.create()
            return component!!
        }

        fun reset() {
            component = null
        }

    }

}
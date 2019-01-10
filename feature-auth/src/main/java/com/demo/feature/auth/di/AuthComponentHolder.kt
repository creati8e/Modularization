package com.demo.feature.auth.di

import com.demo.core.api.ui.FeatureComponent
import com.demo.feature.auth.presentation.AuthFragment
import com.demo.injector.Injector

/**
 * @author Sergey Chuprin
 */
class AuthComponentHolder : FeatureComponent<AuthFragment> {

    var component: AuthComponent? = null
        private set

    override fun inject(target: AuthFragment) = component?.inject(target) ?: Unit

    override fun onCreate() {
        component = DaggerAuthComponent
            .builder()
            .authDependencies(Injector.getAuthDependencies())
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
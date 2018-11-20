package com.demo.modularization.feature.impl.di

import android.app.Application
import com.demo.modularization.feature.impl.presentation.AuthFragment
import demo.com.componentstore.FeatureComponent
import demo.com.core.api.App

/**
 * @author Sergey Chuprin
 */
class AuthComponentHolder(
    private val application: Application
) : FeatureComponent<AuthFragment> {

    var component: AuthComponent? = null
        private set

    override fun inject(target: AuthFragment) {
        val component = requireNotNull(component) { "Trying to inject, but component is null" }
        component.inject(target)
    }

    override fun onCreate() {
        component = DaggerAuthComponent
            .builder()
            .dataSourcesProvider((application as App).applicationProvider)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
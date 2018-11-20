package com.demo.modularization.feature.impl.di

import android.app.Application
import com.demo.modularization.feature.impl.presentation.AuthFragment
import demo.com.componentstore.FeatureComponent
import demo.com.core.api.App
import demo.com.navigation.NavigationHolder

/**
 * @author Sergey Chuprin
 */
class AuthComponentHolder(
    private val application: Application
) : FeatureComponent<AuthFragment> {

    var component: AuthComponent? = null
        private set

    override fun inject(target: AuthFragment) = component?.inject(target) ?: Unit

    override fun onCreate() {
        component = DaggerAuthComponent
            .builder()
            .dataSourcesProvider((application as App).appProvider)
            .navigationProvider((application as NavigationHolder).navigationProvider)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
package com.demo.modularization.feature.impl.di

import android.app.Application
import com.demo.modularization.feature.impl.presentation.AuthFragment
import demo.com.core.api.AppHolder
import demo.com.navigation.NavigationHolder
import demo.com.utils.ui.FeatureComponent

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
            .dataSourcesProvider((application as AppHolder).appProvider)
            .navigationProvider((application as NavigationHolder).navigationProvider)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
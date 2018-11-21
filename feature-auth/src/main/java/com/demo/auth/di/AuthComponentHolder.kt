package com.demo.auth.di

import android.app.Application
import com.demo.auth.presentation.AuthFragment
import com.demo.core.api.AppHolder
import com.demo.core.navigation.NavigationHolder
import com.demo.core.ui.FeatureComponent

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
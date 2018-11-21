package com.demo.settings.user

import com.demo.core.ui.FeatureComponent
import com.demo.settings.common.di.SettingsProvider

/**
 * @author Sergey Chuprin
 */
class UserInfoComponentHolder(
    private val settingsProvider: SettingsProvider
) : FeatureComponent<UserInfoFragment> {

    private var component: UserInfoComponent? = null

    override fun inject(target: UserInfoFragment) = component?.inject(target) ?: Unit

    override fun onCreate() {
        component = DaggerUserInfoComponent
            .builder()
            .settingsProvider(settingsProvider)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
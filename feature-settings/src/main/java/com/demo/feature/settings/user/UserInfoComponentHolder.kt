package com.demo.feature.settings.user

import com.demo.core.api.ui.FeatureComponent
import com.demo.feature.settings.common.di.SettingsTools

/**
 * @author Sergey Chuprin
 */
class UserInfoComponentHolder(
    private val settingsTools: SettingsTools
) : FeatureComponent<UserInfoFragment> {

    private var component: UserInfoComponent? = null

    override fun inject(target: UserInfoFragment) = component?.inject(target) ?: Unit

    override fun onCreate() {
        component = DaggerUserInfoComponent
            .builder()
            .settingsTools(settingsTools)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
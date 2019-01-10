package com.demo.feature.settings.notifications

import com.demo.core.api.ui.FeatureComponent
import com.demo.feature.settings.common.di.SettingsTools

/**
 * @author Sergey Chuprin
 */
class NotificationsComponentHolder(
    private val settingsTools: SettingsTools
) : FeatureComponent<NotificationsFragment> {

    private var component: NotificationsComponent? = null

    override fun inject(target: NotificationsFragment) = component?.inject(target) ?: Unit

    override fun onCreate() {
        component = DaggerNotificationsComponent
            .builder()
            .settingsTools(settingsTools)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
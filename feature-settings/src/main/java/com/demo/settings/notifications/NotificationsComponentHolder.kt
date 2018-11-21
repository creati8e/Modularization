package com.demo.settings.notifications

import com.demo.core.ui.FeatureComponent
import com.demo.settings.common.di.SettingsProvider

/**
 * @author Sergey Chuprin
 */
class NotificationsComponentHolder(
    private val settingsProvider: SettingsProvider
) : FeatureComponent<NotificationsFragment> {

    private var component: NotificationsComponent? = null

    override fun inject(target: NotificationsFragment) = component?.inject(target) ?: Unit

    override fun onCreate() {
        component = DaggerNotificationsComponent
            .builder()
            .settingsProvider(settingsProvider)
            .build()
    }

    override fun onDestroy() {
        component = null
    }

}
package demo.com.settings.notifications

import demo.com.settings.common.di.SettingsProvider
import demo.com.utils.ui.FeatureComponent

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
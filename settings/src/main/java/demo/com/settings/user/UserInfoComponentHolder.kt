package demo.com.settings.user

import demo.com.settings.common.di.SettingsProvider
import demo.com.utils.ui.FeatureComponent

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
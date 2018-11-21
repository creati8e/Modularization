package demo.com.settings.common.di

import android.app.Application
import demo.com.core.api.AppHolder
import demo.com.settings.SettingsFragment
import demo.com.utils.ui.FeatureComponent

/**
 * @author Sergey Chuprin
 */
class SettingsComponentHolder(
    private val application: Application
) : FeatureComponent<SettingsFragment> {

    val component: SettingsComponent get() = _component!!

    private var _component: SettingsComponent? = null

    override fun inject(target: SettingsFragment) = _component?.inject(target) ?: Unit

    override fun onCreate() {
        _component = DaggerSettingsComponent
            .builder()
            .appUtilsProvider((application as AppHolder).appProvider)
            .build()
    }

    override fun onDestroy() {
        _component = null
    }

}
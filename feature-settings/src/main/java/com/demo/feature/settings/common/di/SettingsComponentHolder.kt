package com.demo.feature.settings.common.di

import com.demo.core.api.ui.FeatureComponent
import com.demo.feature.settings.SettingsFragment
import com.demo.injector.Injector

/**
 * @author Sergey Chuprin
 */
class SettingsComponentHolder : FeatureComponent<SettingsFragment> {

    val component: SettingsComponent get() = _component!!

    private var _component: SettingsComponent? = null

    override fun inject(target: SettingsFragment) = _component?.inject(target) ?: Unit

    override fun onCreate() {
        _component = DaggerSettingsComponent
            .builder()
            .settingsDependencies(Injector.getSettingDependencies())
            .build()
    }

    override fun onDestroy() {
        _component = null
    }

}
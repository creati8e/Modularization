package com.demo.feature.settings.common.di

import com.demo.core.api.di.scope.PerFeature
import com.demo.feature.settings.SettingsFragment
import com.demo.injector.settings.SettingsDependencies
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(
    modules = [SettingsModule::class],
    dependencies = [SettingsDependencies::class]
)
interface SettingsComponent : SettingsTools {

    fun inject(fragment: SettingsFragment)

}
package com.demo.feature.settings.common.di

import com.demo.core.api.di.scope.PerFeature
import com.demo.injector.Injector
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

    companion object {
        fun provide(): SettingsComponent {
            return DaggerSettingsComponent
                .builder()
                .settingsDependencies(Injector.getSettingDependencies())
                .build()
        }
    }

}
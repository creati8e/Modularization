package com.demo.settings.common.di

import com.demo.core.api.di.provider.AppUtilsProvider
import com.demo.core.api.di.scope.PerFeature
import com.demo.settings.SettingsFragment
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerFeature
@Component(
    modules = [SettingsModule::class],
    dependencies = [AppUtilsProvider::class]
)
interface SettingsComponent : SettingsProvider {

    fun inject(fragment: SettingsFragment)

}
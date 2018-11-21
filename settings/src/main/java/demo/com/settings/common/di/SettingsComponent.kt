package demo.com.settings.common.di

import dagger.Component
import demo.com.core.api.di.provider.AppUtilsProvider
import demo.com.core.api.di.scope.PerFeature
import demo.com.settings.SettingsFragment

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
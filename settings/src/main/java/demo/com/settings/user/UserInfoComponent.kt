package demo.com.settings.user

import dagger.Component
import demo.com.core.api.di.scope.PerScreen
import demo.com.settings.common.di.SettingsProvider

/**
 * @author Sergey Chuprin
 */
@PerScreen
@Component(dependencies = [SettingsProvider::class])
interface UserInfoComponent {

    fun inject(fragment: UserInfoFragment)

}
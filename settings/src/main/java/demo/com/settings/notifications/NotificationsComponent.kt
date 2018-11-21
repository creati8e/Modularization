package demo.com.settings.notifications

import dagger.Component
import demo.com.core.api.di.scope.PerScreen
import demo.com.settings.common.di.SettingsProvider

/**
 * @author Sergey Chuprin
 */
@Component(dependencies = [SettingsProvider::class])
@PerScreen
interface NotificationsComponent {

    fun inject(fragment: NotificationsFragment)

}
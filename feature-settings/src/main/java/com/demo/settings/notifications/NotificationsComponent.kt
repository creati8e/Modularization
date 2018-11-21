package com.demo.settings.notifications

import com.demo.core.api.di.scope.PerScreen
import com.demo.settings.common.di.SettingsProvider
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@Component(dependencies = [SettingsProvider::class])
@PerScreen
interface NotificationsComponent {

    fun inject(fragment: NotificationsFragment)

}
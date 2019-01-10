package com.demo.feature.settings.notifications

import com.demo.core.api.di.scope.PerScreen
import com.demo.feature.settings.common.di.SettingsTools
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerScreen
@Component(dependencies = [SettingsTools::class])
interface NotificationsComponent {

    fun inject(fragment: NotificationsFragment)

}
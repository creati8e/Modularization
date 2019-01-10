package com.demo.feature.settings.user

import com.demo.core.api.di.scope.PerScreen
import com.demo.feature.settings.common.di.SettingsTools
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerScreen
@Component(dependencies = [SettingsTools::class])
interface UserInfoComponent {

    fun inject(fragment: UserInfoFragment)

}
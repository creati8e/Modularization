package com.demo.settings.user

import com.demo.core.api.di.scope.PerScreen
import com.demo.settings.common.di.SettingsProvider
import dagger.Component

/**
 * @author Sergey Chuprin
 */
@PerScreen
@Component(dependencies = [SettingsProvider::class])
interface UserInfoComponent {

    fun inject(fragment: UserInfoFragment)

}
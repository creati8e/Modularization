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

    companion object {
        fun provide(settingsTools: SettingsTools): UserInfoComponent {
            return DaggerUserInfoComponent
                .builder()
                .settingsTools(settingsTools)
                .build()
        }
    }

    fun inject(fragment: UserInfoFragment)

}
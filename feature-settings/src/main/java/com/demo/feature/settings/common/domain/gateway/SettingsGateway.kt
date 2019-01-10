package com.demo.feature.settings.common.domain.gateway

import com.demo.feature.settings.common.domain.model.NotificationSettingsModel
import com.demo.feature.settings.common.domain.model.UserSettingsModel

/**
 * @author Sergey Chuprin
 */
interface SettingsGateway {

    var userSettings: UserSettingsModel

    var notificationSettings: NotificationSettingsModel


}
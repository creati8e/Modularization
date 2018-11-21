package com.demo.settings.common.domain.gateway

import com.demo.settings.common.domain.model.NotificationSettingsModel
import com.demo.settings.common.domain.model.UserSettingsModel

/**
 * @author Sergey Chuprin
 */
interface SettingsGateway {

    var userSettings: UserSettingsModel

    var notificationSettings: NotificationSettingsModel


}
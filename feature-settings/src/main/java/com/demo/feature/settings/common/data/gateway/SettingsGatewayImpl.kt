package com.demo.feature.settings.common.data.gateway

import com.demo.feature.settings.common.domain.gateway.SettingsGateway
import com.demo.feature.settings.common.domain.model.NotificationSettingsModel
import com.demo.feature.settings.common.domain.model.UserSettingsModel

/**
 * @author Sergey Chuprin
 */
class SettingsGatewayImpl : SettingsGateway {

    override var userSettings = UserSettingsModel("", "")

    override var notificationSettings = NotificationSettingsModel(false, false)

}
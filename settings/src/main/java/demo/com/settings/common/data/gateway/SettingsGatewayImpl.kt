package demo.com.settings.common.data.gateway

import demo.com.settings.common.domain.gateway.SettingsGateway
import demo.com.settings.common.domain.model.NotificationSettingsModel
import demo.com.settings.common.domain.model.UserSettingsModel

/**
 * @author Sergey Chuprin
 */
class SettingsGatewayImpl : SettingsGateway {

    override var userSettings = UserSettingsModel("", "")

    override var notificationSettings = NotificationSettingsModel(false, false)

}
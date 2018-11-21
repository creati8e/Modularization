package demo.com.settings.common.domain.gateway

import demo.com.settings.common.domain.model.NotificationSettingsModel
import demo.com.settings.common.domain.model.UserSettingsModel

/**
 * @author Sergey Chuprin
 */
interface SettingsGateway {

    var userSettings: UserSettingsModel

    var notificationSettings: NotificationSettingsModel


}
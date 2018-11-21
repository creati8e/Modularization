package demo.com.settings.common.di

import demo.com.settings.common.domain.gateway.SettingsGateway

/**
 * @author Sergey Chuprin
 */
interface SettingsProvider {

    val settingsGateway: SettingsGateway

}
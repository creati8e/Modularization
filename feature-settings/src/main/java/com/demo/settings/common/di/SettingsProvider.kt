package com.demo.settings.common.di

import com.demo.settings.common.domain.gateway.SettingsGateway

/**
 * @author Sergey Chuprin
 */
interface SettingsProvider {

    val settingsGateway: SettingsGateway

}
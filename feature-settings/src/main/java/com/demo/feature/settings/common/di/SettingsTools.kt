package com.demo.feature.settings.common.di

import com.demo.feature.settings.common.domain.gateway.SettingsGateway

/**
 * @author Sergey Chuprin
 */
interface SettingsTools {

    val settingsGateway: SettingsGateway

}
package com.demo.settings.common.di

import com.demo.core.api.di.scope.PerFeature
import com.demo.settings.common.data.gateway.SettingsGatewayImpl
import com.demo.settings.common.domain.gateway.SettingsGateway
import dagger.Module
import dagger.Provides

/**
 * @author Sergey Chuprin
 */
@Module
class SettingsModule {

    @Provides
    @PerFeature
    fun provideSettingsGateway(): SettingsGateway = SettingsGatewayImpl()

}
package demo.com.settings.common.di

import dagger.Module
import dagger.Provides
import demo.com.core.api.di.scope.PerFeature
import demo.com.settings.common.data.gateway.SettingsGatewayImpl
import demo.com.settings.common.domain.gateway.SettingsGateway

/**
 * @author Sergey Chuprin
 */
@Module
class SettingsModule {

    @Provides
    @PerFeature
    fun provideSettingsGateway(): SettingsGateway = SettingsGatewayImpl()

}
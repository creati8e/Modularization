package demo.com.dashboard.impl.di

import dagger.Module
import dagger.Provides
import demo.com.core.api.presentation.ResourcesManager
import demo.com.dashboard.impl.data.DashboardGatewayImpl
import demo.com.dashboard.impl.domain.gateway.DashboardGateway

/**
 * @author Sergey Chuprin
 */
@Module
class DashboardModule {

    @Provides
    fun provideDashboardGateway(resourcesManager: ResourcesManager): DashboardGateway {
        return DashboardGatewayImpl(resourcesManager)
    }

}
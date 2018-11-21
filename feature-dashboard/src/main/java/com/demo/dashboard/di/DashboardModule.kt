package com.demo.dashboard.di

import com.demo.core.api.di.scope.PerFeature
import com.demo.core.api.presentation.ResourcesManager
import com.demo.dashboard.data.DashboardGatewayImpl
import com.demo.dashboard.domain.gateway.DashboardGateway
import dagger.Module
import dagger.Provides

/**
 * @author Sergey Chuprin
 */
@Module
class DashboardModule {

    @Provides
    @PerFeature
    fun provideDashboardGateway(resourcesManager: ResourcesManager): DashboardGateway {
        return DashboardGatewayImpl(resourcesManager)
    }

}